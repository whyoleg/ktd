package dev.whyoleg.ktd.client.updates

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.*
import kotlinx.collections.immutable.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*

class FlowCachedUpdatesManager(job: Job) : UpdatesManager<Flow<TelegramUpdate>> {

    private sealed class Action {
        class Add(val update: TelegramUpdate) : Action()
        class Subscribe(val channel: SendChannel<TelegramUpdate>) : Action()
        class Unsubscribe(val channel: SendChannel<TelegramUpdate>) : Action()
    }

    private val consumeScope = CoroutineScope(Dispatchers.Default + SupervisorJob(job))

    private val cacheChannel = Channel<Action>(Channel.UNLIMITED)

    //key - flow channel, value - unlimited channel
    private val subscribers = mutableMapOf<SendChannel<TelegramUpdate>, SendChannel<TelegramUpdate>>()

    override val updates: Flow<TelegramUpdate> = channelFlow {
        cacheChannel.offer(Action.Subscribe(this))
        awaitClose { cacheChannel.offer(Action.Unsubscribe(this)) }
    }

    init {
        CoroutineScope(Dispatchers.Default + job).launch {
            var cache = persistentListOf<TelegramUpdate>()
            cacheChannel.consumeEach { action ->
                when (action) {
                    is Action.Add         -> {
                        val update = action.update
                        cache += update
                        subscribers.forEach { (_, unlimitedChannel) -> unlimitedChannel.offer(update) }
                    }
                    is Action.Subscribe   -> {
                        val flowChannel = action.channel
                        val unlimitedChannel = unlimitedChannel(flowChannel, cache)
                        subscribers[flowChannel] = unlimitedChannel
                    }
                    is Action.Unsubscribe -> {
                        subscribers.remove(action.channel)?.close()
                    }
                }
            }
        }.invokeOnCompletion { error ->
            subscribers.forEach { (flowChannel, _) -> flowChannel.close(error) }
            subscribers.clear()
        }
    }

    private fun unlimitedChannel(flowChannel: SendChannel<TelegramUpdate>, cache: List<TelegramUpdate>): SendChannel<TelegramUpdate> {
        val unlimitedChannel = Channel<TelegramUpdate>(Channel.UNLIMITED)
        consumeScope.launch {
            cache.forEach { flowChannel.send(it) }
            unlimitedChannel.consumeEach { flowChannel.send(it) }
        }
        return unlimitedChannel
    }

    override fun handle(update: TelegramUpdate) {
        cacheChannel.offer(Action.Add(update))
    }

}

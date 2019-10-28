package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import kotlinx.collections.immutable.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*

private sealed class UpdateAction {
    class Add(val update: TelegramUpdate) : UpdateAction()
    class Subscribe(val channel: SendChannel<TelegramUpdate>) : UpdateAction()
    class Unsubscribe(val channel: SendChannel<TelegramUpdate>) : UpdateAction()
}

internal class UpdatesChannel(job: Job) {
    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob(job))

    private var cache = persistentListOf<TelegramUpdate>()
    private val cacheChannel = Channel<UpdateAction>(Channel.UNLIMITED)

    //key - flow channel, value - unlimited channel
    private val subscribers = mutableMapOf<SendChannel<TelegramUpdate>, SendChannel<TelegramUpdate>>()

    val flow: Flow<TelegramUpdate> = channelFlow {
        cacheChannel.offer(UpdateAction.Subscribe(this))
        awaitClose { cacheChannel.offer(UpdateAction.Unsubscribe(this)) }
    }

    init {
        scope.launch {
            cacheChannel.consumeEach { action ->
                when (action) {
                    is UpdateAction.Add         -> {
                        val update = action.update
                        cache += update
                        subscribers.forEach { (_, unlimitedChannel) -> unlimitedChannel.offer(update) }
                    }
                    is UpdateAction.Subscribe   -> {
                        val flowChannel = action.channel
                        val unlimitedChannel = unlimitedChannel(flowChannel, cache)
                        subscribers[flowChannel] = unlimitedChannel
                    }
                    is UpdateAction.Unsubscribe -> {
                        subscribers.remove(action.channel)?.close()
                    }
                }
            }
        }.invokeOnCompletion { error ->
            subscribers.forEach { (flowChannel, unlimitedChannel) -> flowChannel.close(error) }
            subscribers.clear()
        }
    }

    private fun unlimitedChannel(flowChannel: SendChannel<TelegramUpdate>, cache: List<TelegramUpdate>): SendChannel<TelegramUpdate> {
        val unlimitedChannel = Channel<TelegramUpdate>(Channel.UNLIMITED)
        scope.launch {
            cache.forEach { flowChannel.send(it) }
            unlimitedChannel.consumeEach { flowChannel.send(it) }
        }
        return unlimitedChannel
    }

    fun offer(value: TelegramUpdate) {
        cacheChannel.offer(UpdateAction.Add(value))
    }

}

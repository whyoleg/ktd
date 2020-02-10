package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import kotlinx.collections.immutable.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*

class FlowUpdatesCache(job: Job) {

    private sealed class Action {
        class Add(val update: TdUpdate) : Action()
        class Subscribe(val channel: SendChannel<TdUpdate>) : Action()
        class Unsubscribe(val channel: SendChannel<TdUpdate>) : Action()
    }

    private val consumeScope = CoroutineScope(Dispatchers.Default + SupervisorJob(job))

    private val cacheChannel = Channel<Action>(Channel.UNLIMITED)

    //key - flow channel, value - unlimited channel
    private val subscribers = mutableMapOf<SendChannel<TdUpdate>, SendChannel<TdUpdate>>()

    val updates: Flow<TdUpdate> = channelFlow {
        cacheChannel.offer(Action.Subscribe(this))
        awaitClose { cacheChannel.offer(Action.Unsubscribe(this)) }
    }

    init {
        CoroutineScope(Dispatchers.Default + job).launch {
            var cache = persistentListOf<TdUpdate>()
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

    private fun unlimitedChannel(flowChannel: SendChannel<TdUpdate>, cache: List<TdUpdate>): SendChannel<TdUpdate> {
        val unlimitedChannel = Channel<TdUpdate>(Channel.UNLIMITED)
        consumeScope.launch {
            cache.forEach { flowChannel.send(it) }
            unlimitedChannel.consumeEach { flowChannel.send(it) }
        }
        return unlimitedChannel
    }

    fun save(update: TdUpdate) {
        cacheChannel.offer(Action.Add(update))
    }

}

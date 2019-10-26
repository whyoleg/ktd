package dev.whyoleg.ktd

import kotlinx.collections.immutable.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*

internal class UnlimitedCacheChannel<T>(job: Job) {
    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob(job))

    private abstract inner class Action
    private inner class Add(val value: T) : Action()
    private inner class Sub(val channel: SendChannel<T>) : Action()
    private inner class UnSub(val channel: SendChannel<T>) : Action()

    private var cache = persistentListOf<T>()
    private val cacheChannel = Channel<Action>(Channel.UNLIMITED)

    //key - flow channel, value - unlimited channel
    private val subscribers = mutableMapOf<SendChannel<T>, SendChannel<T>>()

    public val flow: Flow<T> = channelFlow {
        cacheChannel.offer(Sub(this))
        awaitClose { cacheChannel.offer(UnSub(this)) }
    }

    init {
        scope.launch {
            cacheChannel.consumeEach { action ->
                when (action) {
                    is Add   -> {
                        val value = action.value
                        cache += value
                        subscribers.forEach { (_, unlimitedChannel) -> unlimitedChannel.offer(value) }
                    }
                    is Sub   -> {
                        val flowChannel = action.channel
                        val unlimitedChannel = unlimitedChannel(flowChannel, cache)
                        subscribers[flowChannel] = unlimitedChannel
                    }
                    is UnSub -> {
                        subscribers.remove(action.channel)?.close()
                    }
                }
            }
        }.invokeOnCompletion { error ->
            subscribers.forEach { (flowChannel, unlimitedChannel) -> flowChannel.close(error) }
            subscribers.clear()
        }
    }

    private fun unlimitedChannel(flowChannel: SendChannel<T>, cache: List<T>): SendChannel<T> {
        val unlimitedChannel = Channel<T>(Channel.UNLIMITED)
        scope.launch {
            cache.forEach { flowChannel.send(it) }
            unlimitedChannel.consumeEach { flowChannel.send(it) }
        }
        return unlimitedChannel
    }

    public fun offer(value: T) {
        cacheChannel.offer(Add(value))
    }

}

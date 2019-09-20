package dev.whyoleg.ktd

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*

internal class UnlimitedCacheChannel<T>(job: Job) {
    private abstract inner class Action
    private inner class Add(val value: T) : Action()
    private inner class Sub(val channel: SendChannel<T>) : Action()
    private inner class UnSub(val channel: SendChannel<T>) : Action()
    private inner class Clear : Action()

    private val list = mutableListOf<T>()
    private val subscribers = mutableSetOf<SendChannel<T>>()

    private val cache = GlobalScope.actor<Action>(Dispatchers.Default + job, Channel.UNLIMITED) {
        consumeEach { action ->
            when (action) {
                is Add   -> {
                    val value = action.value
                    list += value
                    subscribers.forEach { sub -> sub.offer(value) }
                }
                is Sub   -> {
                    val ch = action.channel
                    subscribers += ch
                    list.forEach { ch.offer(it) }
                }
                is UnSub -> subscribers -= action.channel
                is Clear -> list.clear()
            }
        }
    }

    init {
        cache.invokeOnClose { error ->
            subscribers.forEach { it.close(error) }
            subscribers.clear()
            list.clear()
        }
    }

    val flow: Flow<T>
        get() = flow {
            val unlimitedFlow = channelFlow {
                cache.offer(Sub(this))
                awaitClose { cache.offer(UnSub(this)) }
            }.buffer(Channel.UNLIMITED)
            emitAll(unlimitedFlow)
        }

    fun offer(value: T) {
        cache.offer(Add(value))
    }

    fun clear() {
        cache.offer(Clear())
    }
}
package dev.whyoleg.ktd.client.storage

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

class ChannelStorage<T : TelegramResponse>(job: Job) : ResponseHandlerStorage<CompletableDeferred<T>> {
    private val supervisorJob = SupervisorJob(job)
    private val channel = Channel<Action>(Channel.UNLIMITED)

    private inner class Action(val id: Long, val deferred: CompletableDeferred<T>, val set: Boolean)

    init {
        val handlers = mutableMapOf<Long, CompletableDeferred<T>>()
        CoroutineScope(Dispatchers.Default + job).launch {
            channel.consumeEach {
                when (it.set) {
                    true  -> handlers[it.id] = it.deferred
                    false -> {
                        val handler = handlers.remove(it.id)!!
                        when {
                            handler.isActive    -> launch { it.deferred.complete(handler.await()) }
                            handler.isCancelled -> it.deferred.cancel(handler.getCancellationException())
                            handler.isCompleted -> when (val throwable = handler.getCompletionExceptionOrNull()) {
                                null -> it.deferred.complete(handler.getCompleted())
                                else -> it.deferred.completeExceptionally(throwable)
                            }
                        }
                    }
                }
            }
        }.invokeOnCompletion {
            handlers.clear()
        }
    }

    override fun set(requestId: Long, handler: CompletableDeferred<T>) {
        @Suppress("UNCHECKED_CAST")
        channel.offer(Action(requestId, handler, true))
    }

    override fun get(responseId: Long): CompletableDeferred<T> {
        val handler = CompletableDeferred<T>(supervisorJob)
        @Suppress("UNCHECKED_CAST")
        channel.offer(Action(responseId, handler, false))
        return handler
    }

    override fun clear() {
        channel.cancel()
    }
}

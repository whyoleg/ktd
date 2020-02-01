package dev.whyoleg.ktd.client.api

import java.util.concurrent.*

class ConcurrentMapStorage<T : Any> : ResponseHandlerStorage<T> {
    private val handlers = ConcurrentHashMap<Long, T>()
    override fun set(requestId: Long, handler: T) {
        handlers[requestId] = handler
    }

    override fun get(responseId: Long): T = handlers.remove(responseId)!!

    override fun clear() {
        handlers.clear()
    }
}

package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.*
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.*

@PublishedApi
internal class NativeClient {
    val clientId: Long = Client.createNativeClient()
    private val counter = atomic(0L)

    @PublishedApi
    internal val nextEventId
        get() = counter.incrementAndGet()

    val eventIds = LongArray(MAX_EVENTS)
    val events = arrayOfNulls<TelegramObject>(MAX_EVENTS)
    val mutex = Mutex()

    fun destroy(): Unit = Client.destroyNativeClient(clientId)

    fun send(function: TelegramFunction): Long {
        val eventId = nextEventId
        Client.nativeClientSend(clientId, eventId, function)
        return eventId
    }

    suspend inline fun send(function: TelegramFunction, inLock: (evenId: Long) -> Unit): Long {
        val eventId = nextEventId
        mutex.withLock {
            Client.nativeClientSend(clientId, eventId, function)
            inLock(eventId)
        }
        return eventId
    }

    inline fun CoroutineScope.receive(crossinline onEvent: suspend (eventId: Long, obj: TelegramObject) -> Unit): Boolean {
        if (!mutex.tryLock()) return false
        val eventsCount = Client.nativeClientReceive(clientId, eventIds, events, TIMEOUT)
        mutex.unlock()

        launch {
            repeat(eventsCount) { i ->
                events[i]?.let {
                    onEvent(eventIds[i], it)
                    events[i] = null
                }
                eventIds[i] = 0
            }
        }
        return true
    }

    //TODO must be configurable
    companion object {
        const val MAX_EVENTS: Int = 1000
        const val TIMEOUT: Double = 0.01
    }
}
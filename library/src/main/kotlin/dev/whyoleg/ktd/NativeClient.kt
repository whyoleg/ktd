package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.*

internal class NativeClient(private val configuration: TelegramClientConfiguration) {

    private val clientId: Long = Client.createNativeClient()
    fun destroy(): Unit = Client.destroyNativeClient(clientId)

    private val counter = atomic(0L)

    fun send(function: TelegramFunction): Long = counter.incrementAndGet().also {
        Client.nativeClientSend(clientId, it, function)
    }

    private val eventIds = LongArray(configuration.maxEventsCount)
    private val events = arrayOfNulls<TelegramObject>(configuration.maxEventsCount)
    private var eventsCount: Int = 0

    fun receive() {
        check(eventsCount == 0) { "Events are not handled" }
        eventsCount = Client.nativeClientReceive(clientId, eventIds, events, configuration.receiveTimeout)
    }

    internal inline fun handle(onEvent: (eventId: Long, obj: TelegramObject) -> Unit) {
        repeat(eventsCount) { i ->
            events[i]?.let {
                onEvent(eventIds[i], it)
                events[i] = null
            }
            eventIds[i] = 0
        }
        eventsCount = 0
    }
}
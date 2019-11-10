package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.*

internal class NativeClient(configuration: TelegramClientConfiguration) {

    val clientId: Long = TdClient.create()

    private val eventCounter = atomic(0L)
    private val eventIds = LongArray(configuration.maxEventsCount)
    private val events = arrayOfNulls<TelegramObject>(configuration.maxEventsCount)
    private val timeout = configuration.receiveTimeout.inMilliseconds

    fun destroy(): Unit = TdClient.destroy(clientId)

    fun send(function: TelegramFunction): Long {
        val eventId = eventCounter.incrementAndGet()
        TdClient.send(clientId, eventId, function)
        return eventId
    }

    inline fun receive(onEvent: (eventId: Long, obj: TelegramObject) -> Unit) {
        val eventsCount = TdClient.receive(clientId, eventIds, events, timeout)
        repeat(eventsCount) { i ->
            events[i]?.let {
                onEvent(eventIds[i], it)
                events[i] = null
            }
            eventIds[i] = 0
        }
    }
}

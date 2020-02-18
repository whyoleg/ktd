package dev.whyoleg.ktd.api.integration

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*
import kotlin.test.*

abstract class TdlibCompatibilityTestBase {

    @Test
    fun executeFunction() {
        val logLevel = 11
        TelegramRawClient.execute(SetLogVerbosityLevel(logLevel))
        val newLevel = (TelegramRawClient.execute(GetLogVerbosityLevel()) as LogVerbosityLevel).verbosityLevel
        assertEquals(logLevel, newLevel)
        TelegramRawClient.execute(SetLogVerbosityLevel(0))
    }

    @Test
    fun createClient() {
        val clientId = TelegramRawClient.create()
        val clientId2 = TelegramRawClient.create()
        assertNotEquals(clientId, clientId2)
        TelegramRawClient.destroy(clientId)
        TelegramRawClient.destroy(clientId2)
    }

    @Test
    fun receiveUpdates() {
        val clientId = TelegramRawClient.create()
        val ids = LongArray(10)
        val events = arrayOfNulls<TelegramObject>(10)
        TelegramRawClient.receive(clientId, ids, events, 1000.0)
        val receivedEvents = events.filterNotNull()
        assertTrue(receivedEvents.isNotEmpty())
    }

    @Test
    fun sendObject() {
        val clientId = TelegramRawClient.create()
        TelegramRawClient.send(clientId, 1, GetCurrentState())
        val ids = LongArray(10)
        val events = arrayOfNulls<TelegramObject>(10)
        var updates: Updates? = null
        while (updates == null) {
            TelegramRawClient.receive(clientId, ids, events, 10.0)
            updates = events.find { it is Updates } as Updates?
        }
        assertTrue(updates.updates.isNotEmpty())
    }

}

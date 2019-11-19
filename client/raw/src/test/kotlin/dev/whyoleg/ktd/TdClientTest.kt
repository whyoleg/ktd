package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*
import kotlin.test.*

internal class TdClientTest {

    @BeforeTest
    fun init() {
        //TODO remove hack, somehow java.library.path doesn't set in tests
        System.setProperty("java.library.path", java.io.File("").absolutePath + "/libs/1.5.1/${NativeTarget.current().name.toLowerCase()}")
        ClassLoader::class.java.getDeclaredField("sys_paths").apply {
            isAccessible = true
            set(null, null)
        }
    }

    @Test
    fun `execute function`() {
        val logLevel = 11
        TdClient.execute(SetLogVerbosityLevel(logLevel))
        val newLevel = (TdClient.execute(GetLogVerbosityLevel()) as LogVerbosityLevel).verbosityLevel
        assertEquals(logLevel, newLevel)
        TdClient.execute(SetLogVerbosityLevel(0))
    }

    @Test
    fun `create client`() {
        val clientId = TdClient.create()
        val clientId2 = TdClient.create()
        assertNotEquals(clientId, clientId2)
        TdClient.destroy(clientId)
        TdClient.destroy(clientId2)
    }

    @Test
    fun `receive any updates`() {
        val clientId = TdClient.create()
        val ids = LongArray(10)
        val events = arrayOfNulls<TelegramObject>(10)
        TdClient.receive(clientId, ids, events, 1000.0)
        val receivedEvents = events.filterNotNull()
        assertTrue(receivedEvents.isNotEmpty())
    }

    @Test
    fun `send object`() {
        val clientId = TdClient.create()
        TdClient.send(clientId, 1, GetCurrentState())
        val ids = LongArray(10)
        val events = arrayOfNulls<TelegramObject>(10)
        var updates: Updates? = null
        while (updates == null) {
            TdClient.receive(clientId, ids, events, 10.0)
            updates = events.find { it is Updates } as Updates?
        }
        assertTrue(updates.updates.isNotEmpty())
    }

}
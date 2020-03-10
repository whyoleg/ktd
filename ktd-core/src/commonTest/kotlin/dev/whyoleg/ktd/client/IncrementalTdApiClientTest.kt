package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.test.*
import kotlin.test.*

class IncrementalTdApiClientTest {
    @Test
    fun createIsNotCalledBeforeAnyRequest() {
        val api = TestTdApi { EmptyTestTdInstance }
        val client = IncrementalTdApiClient(api)
        assertEquals(0, api.activeClients)
        assertNotNull(api.instanceOrNull(client.id))
        assertEquals(1, api.activeClients)
    }

    @Test
    fun destroyed() {
        val api = TestTdApi { EmptyTestTdInstance }
        val client = IncrementalTdApiClient(api)
        assertNotNull(api.instanceOrNull(client.id))
        client.unsafeDestroy()
        assertNull(api.instanceOrNull(client.id))
        assertEquals(0, api.activeClients)
    }

    @Test
    fun incrementalSend() {
        val api = TestTdApi { EmptyTestTdInstance }
        val client = IncrementalTdApiClient(api)
        assertEquals(1, client.send(TdClose()) { assertEquals(it, 1) })
        assertEquals(2, client.send(TdClose()) { assertEquals(it, 2) })
    }
}

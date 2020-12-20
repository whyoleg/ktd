package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.test.*
import kotlin.test.*

class TdApiClientTest {

    @Test
    fun createIsNotCalledBeforeAnyRequest() {
        val api = TestTdApi { EmptyTestTdInstance }
        val client = TdApiClient(api)
        assertEquals(0, api.activeClients)
        assertNotNull(api.instanceOrNull(client.id))
        assertEquals(1, api.activeClients)
    }

    @Test
    fun destroyed() {
        val api = TestTdApi { EmptyTestTdInstance }
        val client = TdApiClient(api)
        assertNotNull(api.instanceOrNull(client.id))
        client.unsafeDestroy()
        assertNull(api.instanceOrNull(client.id))
        assertEquals(0, api.activeClients)
    }
}

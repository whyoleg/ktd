package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlin.test.*

class TdApiClientTest {
    private class TestTdApi : TdApi {
        override val version: String = "1"

        var clientCreated = false
        var clientDestroyed = false

        override fun createClient(): Long {
            clientCreated = true
            return 1
        }

        override fun destroyClient(clientId: Long) {
            clientDestroyed = true
        }

        override fun sendTo(clientId: Long, request: TdApiRequest) {
            TODO("Not yet implemented")
        }

        override fun receiveFrom(clientId: Long, timeout: Double): TdApiResponse? {
            TODO("Not yet implemented")
        }

        override fun <R : TdResponse> executeSynchronously(request: TdSyncRequest<R>): TdResult<R> {
            TODO("Not yet implemented")
        }
    }

    @Test
    fun createIsNotCalledBeforeAnyRequest() {
        val api = TestTdApi()
        val client = TdApiClient(api)
        assertFalse(api.clientCreated)
        assertEquals(1, client.id)
        assertTrue(api.clientCreated)
    }

    @Test
    fun destroyed() {
        val api = TestTdApi()
        val client = TdApiClient(api)
        assertFalse(api.clientCreated)
        assertFalse(api.clientDestroyed)
        client.unsafeDestroy()
        assertTrue(api.clientCreated)
        assertTrue(api.clientDestroyed)
    }
}

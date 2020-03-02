package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.*
import kotlin.concurrent.*
import kotlin.test.*

class ThreadSafeTdApiClientTest {
    private class TestTdApi : TdApi {
        override val version: String = "1"

        var clientCreated = false
        var clientDestroyed = false

        val counter = atomic(0)
        val locked = atomic(false)

        override fun createClient(): Long {
            clientCreated = true
            return 1
        }

        override fun destroyClient(clientId: Long) {
            clientDestroyed = true
        }

        override fun sendTo(clientId: Long, request: TdApiRequest) {
        }

        override fun receiveFrom(clientId: Long, timeout: Double): TdApiResponse? {
            locked.value = true
            counter.incrementAndGet()
            while (locked.value) Unit
            return TdOk()
        }

        override fun <R : TdResponse> executeSynchronously(request: TdSyncRequest<R>): TdResult<R> {
            TODO("Not yet implemented")
        }
    }

    @Test
    fun createIsNotCalledBeforeAnyRequest() {
        val api = TestTdApi()
        val client = ThreadSafeTdApiClient(api)
        assertFalse(api.clientCreated)
        assertEquals(1, client.id)
        assertTrue(api.clientCreated)
    }

    @Test
    fun destroyed() {
        val api = TestTdApi()
        val client = ThreadSafeTdApiClient(api)
        assertFalse(api.clientCreated)
        assertFalse(api.clientDestroyed)
        client.destroy()
        assertTrue(api.clientCreated)
        assertTrue(api.clientDestroyed)
    }

    @Test
    fun incrementalSend() {
        val api = TestTdApi()
        val client = ThreadSafeTdApiClient(api)
        assertEquals(1, client.send(TdClose()) { assertEquals(it, 1) })
        assertEquals(2, client.send(TdClose()) { assertEquals(it, 2) })
    }

    @Test
    fun singleReceive() {
        val api = TestTdApi()
        val client = ThreadSafeTdApiClient(api)
        assertEquals(0, api.counter.value)
        thread { client.receive() }
        while (api.counter.value == 0) Unit
        assertEquals(1, api.counter.value)
        api.locked.value = false
    }

    @Test
    fun multiReceive() {
        val api = TestTdApi()
        val client = ThreadSafeTdApiClient(api)
        assertEquals(0, api.counter.value)

        thread { client.receive() }
        thread { client.receive() }
        thread { client.receive() }

        Thread.sleep(100)
        assertEquals(1, api.counter.value)
        Thread.sleep(100)
        assertEquals(1, api.counter.value)

        api.locked.value = false
        Thread.sleep(100)
        assertEquals(2, api.counter.value)
        Thread.sleep(100)
        assertEquals(2, api.counter.value)

        api.locked.value = false
        Thread.sleep(100)
        assertEquals(3, api.counter.value)
        Thread.sleep(100)
        assertEquals(3, api.counter.value)

        api.locked.value = false
        Thread.sleep(100)
        assertEquals(3, api.counter.value)
    }

    @Test
    fun destroyLock() {
        val api = TestTdApi()
        val client = ThreadSafeTdApiClient(api)
        assertEquals(0, api.counter.value)
        thread { client.receive() }
        Thread.sleep(100)
        assertEquals(1, api.counter.value)
        api.locked.value = false
        Thread.sleep(100)
        assertEquals(1, api.counter.value)
        thread { client.receive() }
        Thread.sleep(100)
        thread { client.destroy() }
        Thread.sleep(100)
        assertFalse(api.clientDestroyed)
        api.locked.value = false
        Thread.sleep(100)
        assertTrue(api.clientDestroyed)
    }
}

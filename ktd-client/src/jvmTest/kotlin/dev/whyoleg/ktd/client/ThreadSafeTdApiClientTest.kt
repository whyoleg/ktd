package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.test.*
import kotlinx.atomicfu.*
import kotlin.concurrent.*
import kotlin.test.*

class ThreadSafeTdApiClientTest {
    private class ReceiveLockTestTdInstance : TestTdInstance {
        private val _counter = atomic(0)
        private val lock = atomic(false)

        val counter: Int get() = _counter.value
        fun unlock() {
            lock.value = false
        }

        override fun receive(timeout: Double): TdApiResponse? {
            lock.value = true
            _counter.incrementAndGet()
            while (lock.value) Unit
            return TdOk()
        }
    }

    @Test
    fun createIsNotCalledBeforeAnyRequest() {
        val api = TestTdApi(::ReceiveLockTestTdInstance)
        val client = ThreadSafeTdApiClient(api)
        assertEquals(0, api.activeClients)
        assertNotNull(api.instanceOrNull(client.id))
        assertEquals(1, api.activeClients)
    }

    @Test
    fun destroyed() {
        val api = TestTdApi(::ReceiveLockTestTdInstance)
        val client = ThreadSafeTdApiClient(api)
        assertNotNull(api.instanceOrNull(client.id))
        client.destroy()
        assertNull(api.instanceOrNull(client.id))
        assertEquals(0, api.activeClients)
    }

    @Test
    fun incrementalSend() {
        val api = TestTdApi(::ReceiveLockTestTdInstance)
        val client = ThreadSafeTdApiClient(api)
        assertEquals(1, client.send(TdClose()) { assertEquals(it, 1) })
        assertEquals(2, client.send(TdClose()) { assertEquals(it, 2) })
    }

    @Test
    fun singleReceive() {
        val api = TestTdApi(::ReceiveLockTestTdInstance)
        val client = ThreadSafeTdApiClient(api)
        val instance = api.instance(client.id)
        assertEquals(0, instance.counter)
        thread { client.receive() }
        while (instance.counter == 0) Unit
        assertEquals(1, instance.counter)
        instance.unlock()
    }

    @Test
    fun multiReceive() {
        val api = TestTdApi(::ReceiveLockTestTdInstance)
        val client = ThreadSafeTdApiClient(api)
        val instance = api.instance(client.id)
        assertEquals(0, instance.counter)

        thread { client.receive() }
        thread { client.receive() }
        thread { client.receive() }

        Thread.sleep(100)
        assertEquals(1, instance.counter)
        Thread.sleep(100)
        assertEquals(1, instance.counter)

        instance.unlock()
        Thread.sleep(100)
        assertEquals(2, instance.counter)
        Thread.sleep(100)
        assertEquals(2, instance.counter)

        instance.unlock()
        Thread.sleep(100)
        assertEquals(3, instance.counter)
        Thread.sleep(100)
        assertEquals(3, instance.counter)

        instance.unlock()
        Thread.sleep(100)
        assertEquals(3, instance.counter)
    }

    @Test
    fun destroyLock() {
        val api = TestTdApi(::ReceiveLockTestTdInstance)
        val client = ThreadSafeTdApiClient(api)
        val instance = api.instance(client.id)
        assertEquals(0, instance.counter)
        thread { client.receive() }
        Thread.sleep(100)
        assertEquals(1, instance.counter)
        instance.unlock()
        Thread.sleep(100)
        assertEquals(1, instance.counter)
        thread { client.receive() }
        Thread.sleep(100)
        thread { client.destroy() }
        Thread.sleep(100)
        assertNotNull(api.instanceOrNull(client.id))
        instance.unlock()
        Thread.sleep(100)
        assertNull(api.instanceOrNull(client.id))
    }
}

package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.test.*
import kotlinx.atomicfu.*
import kotlin.test.*

class AbstractTdClientTest {
    private class SimpleTdClient(api: TdApi) : AbstractTdClient(api) {
        private val _updates = mutableListOf<TdUpdate>()
        private val _closed = atomic(false)

        val closed: Boolean get() = _closed.value
        val updates: List<TdUpdate> get() = _updates

        override fun onUpdate(update: TdUpdate) {
            _updates += update
        }

        override fun onClose() {
            _closed.value = true
        }
    }

    @Test
    fun onUpdateCallbackCalled() {
        val api = TestTdApi { ManualTestTdInstance() }
        val client = SimpleTdClient(api)
        val instance = api.instance(client.id)
        assertEquals(0, client.updates.size)
        instance.update(TdSomeUpdate(0))
        Thread.sleep(100)
        assertEquals(1, client.updates.size)
        assertEquals(0, (client.updates[0] as TdSomeUpdate).value)
    }

    @Test
    fun onCloseCallbackCalled() {
        val api = TestTdApi { ManualTestTdInstance() }
        val client = SimpleTdClient(api)
        val instance = api.instance(client.id)
        assertFalse(client.closed)
        instance.update(TdUpdateAuthState(TdClosedState))
        Thread.sleep(100)
        assertTrue(client.closed)
    }

}

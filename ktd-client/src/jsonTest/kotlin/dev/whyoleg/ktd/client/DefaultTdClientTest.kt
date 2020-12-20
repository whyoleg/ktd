package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.test.*
import kotlinx.atomicfu.*
import kotlin.test.*

internal object TdClosedState : TdClosed
internal object TdClosingState : TdClosing

internal data class TdUpdateAuthState(override val state: TdState) : TdUpdateState, TdUpdate

internal data class TdSomeUpdate(val value: Int) : TdUpdate

internal data class TdTestResponse(val value: Int, override val extra: TdExtra = TdExtra.EMPTY) : TdResponse
internal data class TdTestRequest(val value: Int, override val extra: TdExtra = TdExtra.EMPTY) : TdRequest<TdTestResponse> {
    override fun withRequestId(id: Long): TdRequest<TdTestResponse> = copy(extra = extra.copy(id = id))
}

internal data class TdTestErrorRequest(val errorCode: Int, override val extra: TdExtra = TdExtra.EMPTY) : TdRequest<TdTestResponse> {
    override fun withRequestId(id: Long): TdRequest<TdTestResponse> = copy(extra = extra.copy(id = id))
}

class DefaultTdClientTest {
    private val mapping: (TdApiRequest) -> TdResponseOrError = {
        when (it) {
            is TdTestRequest      -> TdTestResponse(it.value,
                it.extra)
            is TdClose, is TdDestroy, is TdLogOut                           -> TdOk(it.extra)
            is TdTestErrorRequest -> TdError(it.errorCode, "", it.extra)
            else                                                            -> TdError(322, "", it.extra)
        }
    }

    private fun mappingApi() = TestTdApi { MappingTestTdInstance(mapping) }

    private class Atomic {
        private val atomic = atomic(false)
        var value: Boolean
            get() = atomic.value
            set(value) {
                atomic.value = value
            }
    }

    @Test
    fun onCloseCallbackCalled() {
        val closed = Atomic()
        val api = mappingApi()
        val client = api.defaultTdClient(onClose = { closed.value = true })
        val instance = api.instance(client.id)
        instance.update(TdUpdateAuthState(TdClosedState))
        Thread.sleep(100)
        assertTrue(client.isClosed)
        assertTrue(closed.value)
    }

    @Test
    fun onUpdateCallbackCalled() {
        val updated = Atomic()
        val api = mappingApi()
        val client = api.defaultTdClient(updatesCallback = {
            assertTrue(it is TdSomeUpdate)
            assertEquals(3, it.value)
            updated.value = true
        })
        val instance = api.instance(client.id)
        instance.update(TdSomeUpdate(3))
        Thread.sleep(100)
        assertTrue(updated.value)
    }

    @Test
    fun onUpdateCallbackWithErrorCalled() {
        val atomic = Atomic()
        val updated = Atomic()
        val api = mappingApi()
        val client = api.defaultTdClient(updatesCallback = {
            if (it is TdSomeUpdate && it.value != 3) error("FAIL")
            else updated.value = true
        })
        val instance = api.instance(client.id)
        instance.update(TdSomeUpdate(0))
        Thread.sleep(100)

        assertFalse(atomic.value)
        client.sendCallback(TdTestRequest(10)) {
            val response = assertNotNull(response)
            assertEquals(response.value, 10)
            atomic.value = true
        }

        Thread.sleep(100)
        assertTrue(atomic.value)
        assertFalse(updated.value)
        instance.update(TdSomeUpdate(3))
        Thread.sleep(100)
        assertTrue(updated.value)
    }

    @Test
    fun errorOnSendInClosingState() {
        val api = mappingApi()
        val client = api.defaultTdClient()
        val instance = api.instance(client.id)
        instance.update(TdUpdateAuthState(TdClosingState))
        Thread.sleep(100)
        client.sendCallback(TdTestRequest(3)) {
            val error = assertNotNull(error)
            assertEquals(error.code, 500)
        }
    }

    @Test
    fun errorOnSendAfterClose() {
        val api = mappingApi()
        val client = api.defaultTdClient()
        client.close()
        client.sendCallback(TdTestRequest(3)) {
            val error = assertNotNull(error)
            assertEquals(error.code, 500)
        }
    }

    @Test
    fun responseOnRequest() {
        val atomic = Atomic()
        val api = mappingApi()
        val client = api.defaultTdClient()
        client.sendCallback(TdTestRequest(3)) {
            val response = assertNotNull(response)
            assertEquals(response.value, 3)
            atomic.value = true
        }
        Thread.sleep(100)
        assertTrue(atomic.value)
    }

    @Test
    fun responseWithErrorOnRequest() {
        val atomic1 = Atomic()
        val atomic2 = Atomic()
        val updated = Atomic()
        val api = mappingApi()
        val client = api.defaultTdClient(updatesCallback = { updated.value = true })
        val instance = api.instance(client.id)

        assertFalse(atomic1.value)
        assertFalse(atomic2.value)
        client.sendCallback(TdTestRequest(10)) {
            atomic1.value = true
            error("FAIL")
        }
        Thread.sleep(100)
        assertTrue(atomic1.value)
        assertFalse(updated.value)

        instance.update(TdSomeUpdate(3))
        Thread.sleep(100)
        assertTrue(updated.value)

        client.sendCallback(TdTestRequest(5)) { atomic2.value = true }
        Thread.sleep(100)
        assertTrue(atomic2.value)
    }

    @Test
    fun errorOnRequest() {
        val atomic = Atomic()
        val api = mappingApi()
        val client = api.defaultTdClient()
        client.sendCallback(TdTestErrorRequest(322)) {
            val error = assertNotNull(error)
            assertEquals(error.code, 322)
            atomic.value = true
        }
        Thread.sleep(100)
        assertTrue(atomic.value)
    }

    @Test
    fun callbacksHandled() {
        val api = TestTdApi { ManualTestTdInstance() }
        val client = api.defaultTdClient()
        val instance = api.instance(client.id)
        client.sendCallback(TdTestRequest(3)) {
            val response = assertNotNull(response)
            assertEquals(response.value, 3)
        }
        Thread.sleep(100)
        assertNotNull(api.instanceOrNull(client.id))
        instance.update(TdUpdateAuthState(TdClosedState))
        Thread.sleep(100)
        assertNotNull(api.instanceOrNull(client.id))
        instance.response(TdTestResponse(3, instance.requests[0].extra))
        Thread.sleep(100)
        assertNull(api.instanceOrNull(client.id))
    }

    @Test
    fun ignoreResponse() {
        val api = mappingApi()
        val client = api.defaultTdClient()
        val instance = api.instance(client.id)
        client.sendCallback(TdTestRequest(1))
        client.sendCallback(TdTestRequest(2)) {
            assertEquals(2, response?.value)
        }
        client.sendCallback(TdTestErrorRequest(3))
        client.sendCallback(TdTestErrorRequest(4)) {

        }
        Thread.sleep(100)
        assertNotNull(api.instanceOrNull(client.id))
        instance.update(TdUpdateAuthState(TdClosedState))
        Thread.sleep(100)
        assertNull(api.instanceOrNull(client.id))
    }

}

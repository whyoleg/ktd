package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.test.*
import kotlinx.coroutines.*
import kotlin.test.*

internal object TdClosedState : TdClosed
internal data class TdUpdateAuthState(override val state: TdState) : TdUpdateState, TdUpdate

internal data class TdTestResponse(val value: Int, override val extra: TdExtra = TdExtra.EMPTY) : TdResponse
internal data class TdTestRequest(val value: Int, override val extra: TdExtra = TdExtra.EMPTY) : TdRequest<TdTestResponse> {
    override fun withRequestId(id: Long): TdRequest<TdTestResponse> = copy(extra = extra.copy(id = id))
}

internal data class TdTestErrorRequest(val errorCode: Int, override val extra: TdExtra = TdExtra.EMPTY) : TdRequest<TdTestResponse> {
    override fun withRequestId(id: Long): TdRequest<TdTestResponse> = copy(extra = extra.copy(id = id))
}

class SuspendTdClientTest {
    private val mapping: (TdApiRequest) -> TdResponseOrError = {
        when (it) {
            is TdTestRequest                      -> TdTestResponse(it.value, it.extra)
            is TdTestErrorRequest                 -> TdError(it.errorCode, "", it.extra)
            is TdClose, is TdDestroy, is TdLogOut -> TdOk(it.extra)
            else                                  -> TdError(322, "", it.extra)
        }
    }

    private fun mappingApi() = TestTdApi { MappingTestTdInstance(mapping) }

    @Test
    fun suspendResponse(): Unit = runBlocking {
        val api = mappingApi()
        val client = api.defaultSuspendClient()
        val response = client.exec(TdTestRequest(1))
        assertEquals(1, response.value)
    }

    @Test
    fun suspendError(): Unit = runBlocking {
        val api = mappingApi()
        val client = api.defaultSuspendClient()
        val error = assertFailsWith<TdError> { client.exec(TdTestErrorRequest(322)) }
        assertEquals(322, error.code)
        val response = client.exec(TdTestRequest(1))
        assertEquals(1, response.value)
    }

    @Test
    fun cancel(): Unit = runBlocking {
        val api = mappingApi()
        val client = api.defaultSuspendClient()
        assertNotNull(api.instanceOrNull(client.id))
        client.cancel()
        client.sendCallback(TdTestRequest(322)) {
            assertNotNull(error)
            assertEquals(500, error?.code)
        }
        assertFailsWith<CancellationException> { client.exec(TdTestRequest(322)) }
    }

    @Test
    fun closeCancelJob(): Unit = runBlocking {
        val api = mappingApi()
        val client = api.defaultSuspendClient()
        val instance = api.instance(client.id)
        instance.update(TdUpdateAuthState(TdClosedState))
        delay(100)
        assertTrue(client.isCancelled)
    }

}

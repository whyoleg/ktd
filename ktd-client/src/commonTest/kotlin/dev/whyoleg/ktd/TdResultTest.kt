package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import kotlin.test.*
import kotlin.time.*

val s: Duration = 2.seconds



class TdResultTest {

    private class TestResponse : TdResponse {
        override val extra: TdExtra get() = TdExtra.EMPTY
    }

    @Test
    fun handleError() {
        val result = TdResult<TdOk>(TdError(1, ""))

        assertNotNull(result.error)
        assertNull(result.response)
    }

    @Test
    fun handleOk() {
        val result = TdResult<TdOk>(TdOk())

        assertNull(result.error)
        assertNotNull(result.response)
    }

    @Test
    fun handleCallbackOk() {
        val result = TdResult<TdOk>(TdOk())
        assertTrue { result.handle(onResponse = { true }, onError = { false }) }
    }

    @Test
    fun handleCallbackError() {
        val result = TdResult<TdOk>(TdError(1, ""))
        assertTrue { result.handle(onResponse = { false }, onError = { true }) }
    }

    @Test
    fun handleCallbackFail() {
        val result = TdResult<TestResponse>(TdOk())
        assertFails { result.handle(onResponse = { }, onError = { }) }
    }
}

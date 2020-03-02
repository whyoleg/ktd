package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.*
import kotlin.contracts.*

class IncrementalTdApiClient(api: TdApi) {
    @PublishedApi
    internal val client = TdApiClient(api)

    private val requestId = atomic(0L)

    val id: Long get() = client.id

    @PublishedApi
    internal fun nextRequestId() = requestId.incrementAndGet()

    fun unsafeDestroy(): Unit = client.unsafeDestroy()

    /**
     * TODO Only the top-level functions can have a contract for now.
     */
    @PublishedApi
    internal inline fun send2(request: TdApiRequest, preconfigure: (requestId: Long) -> Unit = {}): Long {
        val requestId = nextRequestId()
        preconfigure(requestId)
        @Suppress("DEPRECATION_ERROR")
        client.send(request.withRequestId(requestId))
        return requestId
    }

    fun unsafeReceive(timeout: Double = TdApi.DEFAULT_RECEIVE_TIMEOUT): TdApiResponse? = client.receive(timeout)
}

/**
 * TODO Only the top-level functions can have a contract for now.
 */
inline fun IncrementalTdApiClient.send(request: TdApiRequest, preconfigure: (requestId: Long) -> Unit = {}): Long {
    contract {
        callsInPlace(preconfigure, InvocationKind.EXACTLY_ONCE)
    }
    return send2(request, preconfigure)
}

package dev.whyoleg.ktd.api.client

import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.*
import kotlin.contracts.*

class IncrementalTdApiClient(api: StaticTdApi) {
    @PublishedApi
    internal val client by lazy { TdApiClient(api) }

    @PublishedApi
    internal val requestId = atomic(0L)

    val id: Long get() = client.id

    fun unsafeDestroy(): Unit = client.unsafeDestroy()

    /**
     * TODO Only the top-level functions can have a contract for now.
     */
    @PublishedApi
    internal inline fun send2(request: TdApiRequest, preconfigure: (requestId: Long) -> Unit = {}): Long {
        val requestId = requestId.incrementAndGet()
        preconfigure(requestId)
        @Suppress("DEPRECATION_ERROR")
        client.send(request.withRequestId(requestId))
        return requestId
    }

    fun receive(timeout: Double = StaticTdApi.DEFAULT_RECEIVE_TIMEOUT): TdApiResponse? = client.receive(timeout)
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
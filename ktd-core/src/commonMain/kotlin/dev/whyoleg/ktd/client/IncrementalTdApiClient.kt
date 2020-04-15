package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.*
import kotlin.contracts.*

/**
 * Client which handles requests ordering on sending request.
 * Can be used to create more complex clients
 *
 * @param api api to work with tdlib
 */
class IncrementalTdApiClient(api: TdApi) {
    @PublishedApi
    internal val client = TdApiClient(api)

    /**
     * Id of tdlib client
     */
    val id: Long get() = client.id

    /**
     * Atomic which used to store request id
     */
    private val requestId = atomic(0L)

    /**
     * Get id for next request
     *
     * @return id for next request
     */
    @PublishedApi
    internal fun nextRequestId() = requestId.incrementAndGet()

    /**
     * Destroy client.
     * Thread unsafe. Will throw an error if called while [unsafeReceive] is in progress
     */
    fun unsafeDestroy(): Unit = client.unsafeDestroy()

    /**
     * Send untyped [TdApiRequest] to tdlib client.
     *
     * @param request untyped request
     * @param preconfigure called before request sent to tdlib
     *
     * @return id of request
     * TODO Only the top-level functions can have a contract for now.
     */
    @PublishedApi
    internal inline fun send2(request: TdApiRequest, preconfigure: (requestId: Long) -> Unit = {}): Long {
        val requestId = nextRequestId()
        preconfigure(requestId)
        @Suppress("DEPRECATION_ERROR")
        client.unsafeSend(request.withRequestId(requestId))
        return requestId
    }

    /**
     * Receive [TdApiResponse] from tdlib client, block thread for maximum [timeout] seconds.
     * Thread unsafe. Will throw an error if called while another [unsafeReceive] is in progress
     *
     * @param timeout maximum duration in seconds to wait for [TdApiResponse]
     *
     * @return received [TdApiResponse] or null if no [TdApiResponse] received during [timeout]
     */
    fun unsafeReceive(timeout: Double = TdApi.DEFAULT_RECEIVE_TIMEOUT): TdApiResponse? = client.unsafeReceive(timeout)
}

/**
 * Send untyped [TdApiRequest] to tdlib client.
 *
 * @param request untyped request
 * @param preconfigure called before request sent to tdlib
 *
 * @return id of request
 * TODO Only the top-level functions can have a contract for now.
 */
@OptIn(ExperimentalContracts::class)
inline fun IncrementalTdApiClient.send(request: TdApiRequest, preconfigure: (requestId: Long) -> Unit = {}): Long {
    contract {
        callsInPlace(preconfigure, InvocationKind.EXACTLY_ONCE)
    }
    return send2(request, preconfigure)
}

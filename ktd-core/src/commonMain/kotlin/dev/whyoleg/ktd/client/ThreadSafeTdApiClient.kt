package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.locks.*
import kotlin.contracts.*

/**
 * Client which handles requests ordering on sending request and is fully thread safe respective to [receive] and [destroy].
 * Any function can be called from any thread.
 * Can be used to create more complex clients
 *
 * @param api api to work with tdlib
 */
class ThreadSafeTdApiClient(api: TdApi) {
    @PublishedApi
    internal val client = IncrementalTdApiClient(api)

    /**
     * Id of tdlib client
     */
    val id: Long get() = client.id

    /**
     * Lock for [receive] and [destroy] to call them synchronously
     */
    private val receiveLock = reentrantLock()

    /**
     * Destroy client.
     * Can be called from any thread
     */
    fun destroy(): Unit = receiveLock.withLock { client.unsafeDestroy() }

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
    internal inline fun send2(request: TdApiRequest, preconfigure: (requestId: Long) -> Unit = {}): Long =
        client.send2(request, preconfigure)

    /**
     * Receive [TdApiResponse] from tdlib client, block thread for maximum [timeout] seconds.
     * Can be called from any thread
     *
     * @param timeout maximum duration in seconds to wait for [TdApiResponse]
     *
     * @return received [TdApiResponse] or null if no [TdApiResponse] received during [timeout]
     */
    fun receive(timeout: Double = TdApi.DEFAULT_RECEIVE_TIMEOUT): TdApiResponse? = receiveLock.withLock { client.unsafeReceive(timeout) }
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
inline fun ThreadSafeTdApiClient.send(request: TdApiRequest, preconfigure: (requestId: Long) -> Unit = {}): Long {
    contract {
        callsInPlace(preconfigure, InvocationKind.EXACTLY_ONCE)
    }
    return send2(request, preconfigure)
}

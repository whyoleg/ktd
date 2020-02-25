package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.locks.*
import kotlin.contracts.*

class ThreadSafeTdApiClient(api: AnyTdApi) {
    @PublishedApi
    internal val client by lazy { IncrementalTdApiClient(api) }

    private val receiveLock = reentrantLock()

    val id: Long get() = client.id
    fun unsafeDestroy(): Unit = client.unsafeDestroy()

    /**
     * TODO Only the top-level functions can have a contract for now.
     */
    @PublishedApi
    internal inline fun send2(request: TdApiRequest, preconfigure: (requestId: Long) -> Unit = {}): Long =
        client.send2(request, preconfigure)

    fun receive(timeout: Double = AnyTdApi.DEFAULT_RECEIVE_TIMEOUT): TdApiResponse? = receiveLock.withLock { client.receive(timeout) }
}

/**
 * TODO Only the top-level functions can have a contract for now.
 */
inline fun ThreadSafeTdApiClient.send(request: TdApiRequest, preconfigure: (requestId: Long) -> Unit = {}): Long {
    contract {
        callsInPlace(preconfigure, InvocationKind.EXACTLY_ONCE)
    }
    return send2(request, preconfigure)
}

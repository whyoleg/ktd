package dev.whyoleg.ktd.api.client

import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.locks.*
import kotlin.contracts.*

class ThreadSafeTelegramApiClient(api: TelegramApi) {
    @PublishedApi
    internal val client = IncrementalTelegramApiClient(api)

    private val receiveLock = reentrantLock()

    fun destroy(): Unit = client.destroy()

    /**
     * TODO Only the top-level functions can have a contract for now.
     */
    @PublishedApi
    internal inline fun send2(request: TelegramApiRequest, preconfigure: (requestId: Long) -> Unit = {}): Long =
        client.send2(request, preconfigure)

    fun receive(timeout: Double = TelegramApi.DEFAULT_TIMEOUT): TelegramApiResponse? = receiveLock.withLock { client.receive(timeout) }
}

/**
 * TODO Only the top-level functions can have a contract for now.
 */
inline fun ThreadSafeTelegramApiClient.send(request: TelegramApiRequest, preconfigure: (requestId: Long) -> Unit = {}): Long {
    contract {
        callsInPlace(preconfigure, InvocationKind.EXACTLY_ONCE)
    }
    return send2(request, preconfigure)
}

/**
 * TODO Only the top-level functions can have a contract for now.
 */
inline fun <T> ThreadSafeTelegramApiClient.sendReturned(request: TelegramApiRequest, preconfigure: (requestId: Long) -> T): T {
    contract {
        callsInPlace(preconfigure, InvocationKind.EXACTLY_ONCE)
    }
    val t: T
    send(request) { t = preconfigure(it) }
    return t
}

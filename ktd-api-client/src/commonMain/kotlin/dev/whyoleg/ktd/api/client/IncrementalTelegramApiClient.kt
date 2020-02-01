package dev.whyoleg.ktd.api.client

import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.*
import kotlin.contracts.*

class IncrementalTelegramApiClient(api: TelegramApi) {
    @PublishedApi
    internal val client = TelegramApiClient(api)

    @PublishedApi
    internal val requestId = atomic(0L)

    fun destroy(): Unit = client.destroy()

    /**
     * TODO Only the top-level functions can have a contract for now.
     */
    @PublishedApi
    internal inline fun send2(request: TelegramApiRequest, preconfigure: (requestId: Long) -> Unit = {}): Long {
        val requestId = requestId.incrementAndGet()
        preconfigure(requestId)
        @Suppress("DEPRECATION_ERROR")
        client.send(request.withRequestId(requestId))
        return requestId
    }

    fun receive(timeout: Double = TelegramApi.DEFAULT_TIMEOUT): TelegramApiResponse? = client.receive(timeout)
}

/**
 * TODO Only the top-level functions can have a contract for now.
 */
inline fun IncrementalTelegramApiClient.send(request: TelegramApiRequest, preconfigure: (requestId: Long) -> Unit = {}): Long {
    contract {
        callsInPlace(preconfigure, InvocationKind.EXACTLY_ONCE)
    }
    return send2(request, preconfigure)
}

/**
 * TODO Only the top-level functions can have a contract for now.
 */
inline fun <T> IncrementalTelegramApiClient.sendReturned(request: TelegramApiRequest, preconfigure: (requestId: Long) -> T): T {
    contract {
        callsInPlace(preconfigure, InvocationKind.EXACTLY_ONCE)
    }
    val t: T
    send(request) { t = preconfigure(it) }
    return t
}

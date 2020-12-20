package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*

expect class TdClient {

    inline fun send(request: (requestId: Long) -> TdApiRequest): Long

    fun receive(timeout: Double = TdApi.DEFAULT_RECEIVE_TIMEOUT): TdResult?

    fun close()

    fun closeAndDestroy()

    fun clean()
}

@Suppress("NOTHING_TO_INLINE")
inline fun TdClient.send(request: TdApiRequest): Long = send { request }

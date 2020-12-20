package dev.whyoleg.ktd.api

import dev.whyoleg.ktd.client.*

expect class TdApi {

    val version: String

    fun client(threadSafe: Boolean = true): TdClient

    fun <R : TdResponse> execute(request: TdSyncRequest<R>): TdTypedResult<R>

    companion object {
        /**
         * Default timeout for waiting response from tdlib
         */
        val DEFAULT_RECEIVE_TIMEOUT: Double
    }
}

package dev.whyoleg.ktd.api

import dev.whyoleg.ktd.client.*
import dev.whyoleg.ktd.json.*

actual class TdApi internal constructor(actual val version: String, private val serializer: TdJsonSerializer) {
    actual fun client(threadSafe: Boolean): TdClient = TdClient(serializer, threadSafe)

    actual fun <R : TdResponse> execute(request: TdSyncRequest<R>): TdTypedResult<R> =
        serializer.executeResult(TdJson.execute(serializer.executeRequest(request)))

    actual companion object {
        /**
         * Default timeout for waiting response from tdlib
         */
        actual val DEFAULT_RECEIVE_TIMEOUT: Double = 300.0
    }

}

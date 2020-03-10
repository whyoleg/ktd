package dev.whyoleg.ktd.api

import dev.whyoleg.ktd.*

/**
 * Untyped request to tdlib.
 * Types handled on client level
 */
typealias TdApiRequest = TdRequest<*>

/**
 * Represents request with associated [TdResponse] of type [R].
 * Response from TdApi will be of type [TdResponseOrError]
 *
 * @param R type of associated [TdResponse]
 */
interface TdRequest<R : TdResponse> : TdPayload {
    /**
     * Implementation will be generated and will be equal to `copy(extra = extra.copy(id = id))`.
     * Used to link [TdRequest] with [TdResponse]
     */
    @Deprecated(message = "Generated, used internally to link requests and responses", level = DeprecationLevel.ERROR)
    fun withRequestId(id: Long): TdRequest<R>
}

/**
 * Represents [TdRequest] which can be executed synchronously using [TdApi.executeSynchronously]
 */
interface TdSyncRequest<R : TdResponse> : TdRequest<R>

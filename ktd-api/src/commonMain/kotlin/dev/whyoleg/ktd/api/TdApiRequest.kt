package dev.whyoleg.ktd.api

/**
 * Requests to [StaticTdApi] are untyped.
 * Typing need to be handled on clients level.
 */
typealias TdApiRequest = TdRequest<*>

/**
 * Represents request with associated [TdResponse] of type [R].
 * Response from [StaticTdApi] will be of type [TdResponseOrError]
 */
interface TdRequest<R : TdResponse> : TdPayload {
    /**
     * Implementation will be generated and will be equal to `copy(extra = extra.copy(id = id))`.
     * Used to link [TdRequest] with [TdResponse].
     */
    @Deprecated(message = "Generated, used internally to link requests and responses", level = DeprecationLevel.ERROR)
    fun withRequestId(id: Long): TdRequest<R>
}

/**
 * Represents [TdRequest] which can be executed synchronously.
 */
interface SyncTdRequest<R : TdResponse> : TdRequest<R>

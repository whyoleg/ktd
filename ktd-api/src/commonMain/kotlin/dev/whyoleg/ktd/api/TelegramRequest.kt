package dev.whyoleg.ktd.api

/**
 * Represents request with associated [TelegramResponse] of type [R].
 * Response from [TelegramApi] will be of type [TelegramResponseOrError]
 */
interface TelegramRequest<R : TelegramResponse> : TelegramPayload {
    /**
     * Implementation will be generated and will be equal to `copy(extra = extra.copy(id = id))`.
     * Used to link [TelegramRequest] with [TelegramResponse].
     */
    @Deprecated(message = "Generated, used internally to link requests and responses", level = DeprecationLevel.ERROR)
    fun withRequestId(id: Long): TelegramRequest<R>
}

/**
 * Represents [TelegramRequest] which can be executed synchronously.
 */
interface SyncTelegramRequest<R : TelegramResponse> : TelegramRequest<R>

/**
 * Requests to [TelegramApi] are untyped.
 * Typing need to be handled on clients level.
 */
typealias TelegramApiRequest = TelegramRequest<*>

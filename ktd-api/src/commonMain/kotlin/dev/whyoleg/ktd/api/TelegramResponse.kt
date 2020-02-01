package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents any response from [TelegramApi]: [TelegramUpdate], [TelegramResponse], [TelegramError].
 */
interface TelegramApiResponse : TelegramPayload

/**
 * Represents update from [TelegramApi].
 */
interface TelegramUpdate : TelegramApiResponse

/**
 * Represents [TelegramResponse] or [TelegramError] which will be handled by client.
 */
interface TelegramResponseOrError : TelegramApiResponse

/**
 * Represents untyped response of [TelegramRequest].
 */
interface TelegramResponse : TelegramResponseOrError

/**
 * Represents error from [TelegramApi]
 */
@Serializable
data class TelegramError(
    val code: Int,
    override val message: String,
    override val extra: TelegramExtra = TelegramExtra()
) : RuntimeException("$code: $message"), TelegramResponseOrError

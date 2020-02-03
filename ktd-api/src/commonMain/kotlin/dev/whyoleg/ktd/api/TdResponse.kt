package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents any response from [StaticTdApi]: [TdUpdate], [TdResponse], [TdError].
 */
interface TdApiResponse : TdPayload

/**
 * Represents update from [StaticTdApi].
 */
interface TdUpdate : TdApiResponse

/**
 * Represents [TdResponse] or [TdError] which will be handled by client.
 */
interface TdResponseOrError : TdApiResponse

/**
 * Represents untyped response of [TdRequest].
 */
interface TdResponse : TdResponseOrError

/**
 * Represents error from [StaticTdApi]
 */
@Serializable
@SerialName("error")
data class TdError(
    val code: Int,
    override val message: String,
    override val extra: TdExtra = TdExtra()
) : RuntimeException("$code: $message"), TdResponseOrError

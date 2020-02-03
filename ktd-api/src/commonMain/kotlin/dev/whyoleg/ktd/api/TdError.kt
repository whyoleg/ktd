package dev.whyoleg.ktd.api

import kotlinx.serialization.*

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

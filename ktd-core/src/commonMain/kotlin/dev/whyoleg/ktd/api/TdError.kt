package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * An object of this type can be returned on every function call, in case of an error
 * Represents error from [AnyTdApi]
 *
 * @property code Error code
 *                If the error code is 406, the error message must not be processed in any way and must not be displayed to the user
 * @property message Error message
 */
@Serializable
@SerialName("error")
data class TdError(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    override val message: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra()
) : RuntimeException("$code: $message"), TdResponseOrError

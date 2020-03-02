package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * An object of this type is returned on a successful function call for certain functions
 */
@Serializable
@SerialName("ok")
data class TdOk(@SerialName("@extra") override val extra: TdExtra = TdExtra.EMPTY) : TdResponse

/**
 * An object of this type can be returned on every function call, in case of an error
 * Represents error from [TdApi]
 *
 * @property code Error code
 *                If the error code is 406, the error message must not be processed in any way and must not be displayed to the user
 * @property message Error message
 */
@Serializable
@SerialName("error")
data class TdError(
    @SerialName("code") val code: Int,
    @SerialName("message") override val message: String,
    @SerialName("@extra") override val extra: TdExtra = TdExtra.EMPTY
) : RuntimeException("$code: $message"), TdResponseOrError

/**
 * Closes the TDLib instance.
 * All databases will be flushed to disk and properly closed.
 * After the close completes, updateAuthorizationState with authorizationStateClosed will be sent
 */
@Serializable
@SerialName("close")
data class TdClose(@SerialName("@extra") override val extra: TdExtra = TdExtra.EMPTY) : TdRequest<TdOk> {
    override fun withRequestId(id: Long): TdClose = copy(extra = extra.copy(id = id))
}

/**
 * Closes the TDLib instance, destroying all local data without a proper logout.
 * The current user session will remain in the list of all active sessions.
 * All local data will be destroyed. After the destruction completes updateAuthorizationState with authorizationStateClosed will be sent
 */
@Serializable
@SerialName("destroy")
data class TdDestroy(@SerialName("@extra") override val extra: TdExtra = TdExtra.EMPTY) : TdRequest<TdOk> {
    override fun withRequestId(id: Long): TdDestroy = copy(extra = extra.copy(id = id))
}

/**
 * Closes the TDLib instance after a proper logout.
 * Requires an available network connection.
 * All local data will be destroyed.
 * After the logout completes, updateAuthorizationState with authorizationStateClosed will be sent
 */
@Serializable
@SerialName("logOut")
data class TdLogOut(@SerialName("@extra") override val extra: TdExtra = TdExtra.EMPTY) : TdRequest<TdOk> {
    override fun withRequestId(id: Long): TdLogOut = copy(extra = extra.copy(id = id))
}

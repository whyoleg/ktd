package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Closes the TDLib instance after a proper logout.
 * Requires an available network connection.
 * All local data will be destroyed.
 * After the logout completes, updateAuthorizationState with authorizationStateClosed will be sent
 */
@Serializable
@SerialName("logOut")
data class TdLogOut(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    override fun withRequestId(id: Long): TdLogOut = copy(extra = extra.copy(id = id))
}

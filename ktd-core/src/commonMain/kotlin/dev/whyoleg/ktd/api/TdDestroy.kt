package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Closes the TDLib instance, destroying all local data without a proper logout.
 * The current user session will remain in the list of all active sessions.
 * All local data will be destroyed. After the destruction completes updateAuthorizationState with authorizationStateClosed will be sent
 */
@Serializable
@SerialName("destroy")
data class TdDestroy(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    override fun withRequestId(id: Long): TdDestroy = copy(extra = extra.copy(id = id))
}

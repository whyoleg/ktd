package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns all updates needed to restore current TDLib state, i.e
 * All actual UpdateAuthorizationState/UpdateUser/UpdateNewChat and others
 * This is especially useful if TDLib is run in a separate process
 * This is an offline method
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getCurrentState")
data class TdGetCurrentState(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdUpdates> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetCurrentState {
        return copy(extra = extra.copy(id = id))
    }
}

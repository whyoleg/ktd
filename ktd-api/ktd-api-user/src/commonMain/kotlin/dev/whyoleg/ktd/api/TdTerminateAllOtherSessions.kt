package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Terminates all other sessions of the current user
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("terminateAllOtherSessions")
data class TdTerminateAllOtherSessions(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTerminateAllOtherSessions {
        return copy(extra = extra.copy(id = id))
    }
}

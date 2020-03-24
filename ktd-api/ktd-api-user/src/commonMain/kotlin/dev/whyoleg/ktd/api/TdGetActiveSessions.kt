package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns all active sessions of the current user
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getActiveSessions")
data class TdGetActiveSessions(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdSessions> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetActiveSessions {
        return copy(extra = extra.copy(id = id))
    }
}

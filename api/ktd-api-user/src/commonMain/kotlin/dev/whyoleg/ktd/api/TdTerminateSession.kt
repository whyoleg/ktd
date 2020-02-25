package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Terminates a session of the current user
 *
 * @property sessionId Session identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("terminateSession")
data class TdTerminateSession(
    @SerialName("session_id")
    val sessionId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTerminateSession {
        return copy(extra = extra.copy(id = id))
    }
}

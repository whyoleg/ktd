package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Discards a call
 *
 * @property callId Call identifier
 * @property isDisconnected True, if the user was disconnected
 * @property duration The call duration, in seconds
 * @property connectionId Identifier of the connection used during the call
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("discardCall")
data class TdDiscardCall(
    @SerialName("call_id")
    val callId: Int = 0,
    @SerialName("is_disconnected")
    val isDisconnected: Boolean = false,
    @SerialName("duration")
    val duration: Int = 0,
    @SerialName("connection_id")
    val connectionId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDiscardCall {
        return copy(extra = extra.copy(id = id))
    }
}

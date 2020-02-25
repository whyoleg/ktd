package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Accepts an incoming call
 *
 * @property callId Call identifier
 * @property protocol Description of the call protocols supported by the client
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("acceptCall")
data class TdAcceptCall(
    @SerialName("call_id")
    val callId: Int = 0,
    @SerialName("protocol")
    val protocol: TdCallProtocol? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAcceptCall {
        return copy(extra = extra.copy(id = id))
    }
}

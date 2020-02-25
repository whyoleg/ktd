package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Creates a new call
 *
 * @property userId Identifier of the user to be called
 * @property protocol Description of the call protocols supported by the client
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("createCall")
data class TdCreateCall(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("protocol")
    val protocol: TdCallProtocol? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdCallId> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCreateCall {
        return copy(extra = extra.copy(id = id))
    }
}

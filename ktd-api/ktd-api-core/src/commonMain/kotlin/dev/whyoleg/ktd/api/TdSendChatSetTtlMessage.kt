package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the current TTL setting (sets a new self-destruct timer) in a secret chat and sends the corresponding message
 *
 * @property chatId Chat identifier
 * @property ttl New TTL value, in seconds
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendChatSetTtlMessage")
data class TdSendChatSetTtlMessage(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("ttl")
    val ttl: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendChatSetTtlMessage {
        return copy(extra = extra.copy(id = id))
    }
}

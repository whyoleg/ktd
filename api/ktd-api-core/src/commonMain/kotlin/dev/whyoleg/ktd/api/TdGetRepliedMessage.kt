package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a message that is replied by given message
 *
 * @property chatId Identifier of the chat the message belongs to
 * @property messageId Identifier of the message reply to which get
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getRepliedMessage")
data class TdGetRepliedMessage(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetRepliedMessage {
        return copy(extra = extra.copy(id = id))
    }
}

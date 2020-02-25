package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends a message
 * Returns the sent message
 *
 * @property chatId Target chat
 * @property replyToMessageId Identifier of the message to reply to or 0
 * @property options Options to be used to send the message
 * @property replyMarkup Markup for replying to the message
 * @property inputMessageContent The content of the message to be sent
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendMessage")
data class TdSendMessage(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("reply_to_message_id")
    val replyToMessageId: Long = 0L,
    @SerialName("options")
    val options: TdSendMessageOptions? = null,
    @SerialName("input_message_content")
    val inputMessageContent: TdInputMessageContent? = null,
    @SerialName("reply_markup")
    @TdBotsOnly
    val replyMarkup: TdReplyMarkup? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendMessage {
        return copy(extra = extra.copy(id = id))
    }
}

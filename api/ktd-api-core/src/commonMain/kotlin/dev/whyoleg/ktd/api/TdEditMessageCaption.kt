package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Edits the message content caption
 * Returns the edited message after the edit is completed on the server side
 *
 * @property chatId The chat the message belongs to
 * @property messageId Identifier of the message
 * @property replyMarkup The new message reply markup
 * @property caption New message content caption
 *                   0-GetOption("message_caption_length_max") characters
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("editMessageCaption")
data class TdEditMessageCaption(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("caption")
    val caption: TdFormattedText? = null,
    @SerialName("reply_markup")
    @TdBotsOnly
    val replyMarkup: TdReplyMarkup? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdEditMessageCaption {
        return copy(extra = extra.copy(id = id))
    }
}

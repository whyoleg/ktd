package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Edits the text of an inline text or game message sent via a bot
 *
 * @property inlineMessageId Inline message identifier
 * @property replyMarkup The new message reply markup
 * @property inputMessageContent New text content of the message
 *                               Should be of type InputMessageText
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("editInlineMessageText")
data class TdEditInlineMessageText(
    @SerialName("inline_message_id")
    val inlineMessageId: String? = null,
    @SerialName("reply_markup")
    val replyMarkup: TdReplyMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: TdInputMessageContent? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdEditInlineMessageText {
        return copy(extra = extra.copy(id = id))
    }
}

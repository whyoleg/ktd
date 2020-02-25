package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Edits the caption of an inline message sent via a bot
 *
 * @property inlineMessageId Inline message identifier
 * @property replyMarkup The new message reply markup
 * @property caption New message content caption
 *                   0-GetOption("message_caption_length_max") characters
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("editInlineMessageCaption")
data class TdEditInlineMessageCaption(
    @SerialName("inline_message_id")
    val inlineMessageId: String? = null,
    @SerialName("reply_markup")
    val replyMarkup: TdReplyMarkup? = null,
    @SerialName("caption")
    val caption: TdFormattedText? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdEditInlineMessageCaption {
        return copy(extra = extra.copy(id = id))
    }
}

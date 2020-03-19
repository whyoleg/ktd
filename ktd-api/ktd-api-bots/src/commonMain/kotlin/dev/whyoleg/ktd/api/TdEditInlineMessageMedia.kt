package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Edits the content of a message with an animation, an audio, a document, a photo or a video in an inline message sent via a bot
 *
 * @property inlineMessageId Inline message identifier
 * @property replyMarkup The new message reply markup
 * @property inputMessageContent New content of the message
 *                               Must be one of the following types: InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or InputMessageVideo
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("editInlineMessageMedia")
data class TdEditInlineMessageMedia(
    @SerialName("inline_message_id")
    val inlineMessageId: String? = null,
    @SerialName("input_message_content")
    val inputMessageContent: TdInputMessageContent? = null,
    @SerialName("reply_markup")
    @TdBotsOnly
    val replyMarkup: TdReplyMarkup? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdEditInlineMessageMedia {
        return copy(extra = extra.copy(id = id))
    }
}

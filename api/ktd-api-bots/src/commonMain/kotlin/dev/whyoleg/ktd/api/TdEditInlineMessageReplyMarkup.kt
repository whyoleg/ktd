package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Edits the reply markup of an inline message sent via a bot
 *
 * @property inlineMessageId Inline message identifier
 * @property replyMarkup The new message reply markup
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("editInlineMessageReplyMarkup")
data class TdEditInlineMessageReplyMarkup(
    @SerialName("inline_message_id")
    val inlineMessageId: String? = null,
    @SerialName("reply_markup")
    val replyMarkup: TdReplyMarkup? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdEditInlineMessageReplyMarkup {
        return copy(extra = extra.copy(id = id))
    }
}

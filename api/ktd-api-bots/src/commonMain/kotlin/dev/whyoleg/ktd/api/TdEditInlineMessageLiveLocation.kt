package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Edits the content of a live location in an inline message sent via a bot
 *
 * @property inlineMessageId Inline message identifier
 * @property replyMarkup The new message reply markup
 * @property location New location content of the message
 *                    Pass null to stop sharing the live location
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("editInlineMessageLiveLocation")
data class TdEditInlineMessageLiveLocation(
    @SerialName("inline_message_id")
    val inlineMessageId: String? = null,
    @SerialName("reply_markup")
    val replyMarkup: TdReplyMarkup? = null,
    @SerialName("location")
    val location: TdLocation? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdEditInlineMessageLiveLocation {
        return copy(extra = extra.copy(id = id))
    }
}

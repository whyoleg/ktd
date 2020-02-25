package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Edits the message reply markup
 * Returns the edited message after the edit is completed on the server side
 *
 * @property chatId The chat the message belongs to
 * @property messageId Identifier of the message
 * @property replyMarkup The new message reply markup
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("editMessageReplyMarkup")
data class TdEditMessageReplyMarkup(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("reply_markup")
    val replyMarkup: TdReplyMarkup? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdEditMessageReplyMarkup {
        return copy(extra = extra.copy(id = id))
    }
}

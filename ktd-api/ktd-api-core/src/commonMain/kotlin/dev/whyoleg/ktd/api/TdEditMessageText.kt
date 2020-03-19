package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Edits the text of a message (or a text of a game message)
 * Returns the edited message after the edit is completed on the server side
 *
 * @property chatId The chat the message belongs to
 * @property messageId Identifier of the message
 * @property replyMarkup The new message reply markup
 * @property inputMessageContent New text content of the message
 *                               Should be of type InputMessageText
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("editMessageText")
data class TdEditMessageText(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("input_message_content")
    val inputMessageContent: TdInputMessageContent? = null,
    @SerialName("reply_markup")
    @TdBotsOnly
    val replyMarkup: TdReplyMarkup? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdEditMessageText {
        return copy(extra = extra.copy(id = id))
    }
}

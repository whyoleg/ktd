package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Stops a poll
 * A poll in a message can be stopped when the message has can_be_edited flag set
 *
 * @property chatId Identifier of the chat to which the poll belongs
 * @property messageId Identifier of the message containing the poll
 * @property replyMarkup The new message reply markup
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("stopPoll")
data class TdStopPoll(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("reply_markup")
    @TdBotsOnly
    val replyMarkup: TdReplyMarkup? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdStopPoll {
        return copy(extra = extra.copy(id = id))
    }
}

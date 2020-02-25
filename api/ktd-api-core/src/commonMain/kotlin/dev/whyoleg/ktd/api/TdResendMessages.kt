package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Resends messages which failed to send
 * Can be called only for messages for which messageSendingStateFailed.can_retry is true and after specified in messageSendingStateFailed.retry_after time passed
 * If a message is re-sent, the corresponding failed to send message is deleted
 * Returns the sent messages in the same order as the message identifiers passed in message_ids
 * If a message can't be re-sent, null will be returned instead of the message
 *
 * @property chatId Identifier of the chat to send messages
 * @property messageIds Identifiers of the messages to resend
 *                      Message identifiers must be in a strictly increasing order
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("resendMessages")
data class TdResendMessages(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_ids")
    val messageIds: LongArray = longArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessages> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdResendMessages {
        return copy(extra = extra.copy(id = id))
    }
}

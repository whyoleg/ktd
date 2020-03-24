package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

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
suspend fun SuspendTdClient.resendMessages(
    chatId: Long = 0L,
    messageIds: LongArray = longArrayOf(),
    extra: TdExtra = TdExtra.EMPTY
): TdMessages = exec(TdResendMessages(chatId, messageIds, extra))

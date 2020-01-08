@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Resends messages which failed to send
 * Can be called only for messages for which messageSendingStateFailed.can_retry is true and after specified in messageSendingStateFailed.retry_after time passed
 * If a message is re-sent, the corresponding failed to send message is deleted
 * Returns the sent messages in the same order as the message identifiers passed in message_ids
 * If a message can't be re-sent, null will be returned instead of the message
 *
 * @chatId - Identifier of the chat to send messages
 * @messageIds - Identifiers of the messages to resend
 *               Message identifiers must be in a strictly increasing order
 */
suspend fun TelegramClient.resendMessages(
    chatId: Long = 0L,
    messageIds: LongArray = longArrayOf()
): Messages = message(
    ResendMessages(
        chatId,
        messageIds
    )
)

/**
 * Resends messages which failed to send
 * Can be called only for messages for which messageSendingStateFailed.can_retry is true and after specified in messageSendingStateFailed.retry_after time passed
 * If a message is re-sent, the corresponding failed to send message is deleted
 * Returns the sent messages in the same order as the message identifiers passed in message_ids
 * If a message can't be re-sent, null will be returned instead of the message
 */
suspend fun TelegramClient.message(
    f: ResendMessages
): Messages = exec(f) as Messages

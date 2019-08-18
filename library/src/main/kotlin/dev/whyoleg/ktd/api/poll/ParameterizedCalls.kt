@file:Suppress("unused")

package dev.whyoleg.ktd.api.poll

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes user answer to a poll
 *
 * @chatId - Identifier of the chat to which the poll belongs
 * @messageId - Identifier of the message containing the poll
 * @optionIds - 0-based identifiers of options, chosen by the user. Currently user can't choose more than 1 option
 */
suspend fun TelegramClient.setPollAnswer(
    chatId: Long,
    messageId: Long,
    optionIds: IntArray
): Ok = poll(
    SetPollAnswer(
        chatId,
        messageId,
        optionIds
    )
)

/**
 * Stops a poll. A poll in a message can be stopped when the message has can_be_edited flag set
 *
 * @chatId - Identifier of the chat to which the poll belongs
 * @messageId - Identifier of the message containing the poll
 * @replyMarkup - The new message reply markup; for bots only
 */
suspend fun TelegramClient.stopPoll(
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup
): Ok = poll(
    StopPoll(
        chatId,
        messageId,
        replyMarkup
    )
)

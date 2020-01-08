@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.poll

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Stops a poll
 * A poll in a message can be stopped when the message has can_be_edited flag set
 *
 * @chatId - Identifier of the chat to which the poll belongs
 * @messageId - Identifier of the message containing the poll
 * @replyMarkup - The new message reply markup
 */
suspend fun TelegramClient.stopPoll(
    chatId: Long = 0L,
    messageId: Long = 0L,
    @BotsOnly replyMarkup: ReplyMarkup? = null
): Ok = poll(
    StopPoll(
        chatId,
        messageId,
        replyMarkup
    )
)

/**
 * Stops a poll
 * A poll in a message can be stopped when the message has can_be_edited flag set
 */
suspend fun TelegramClient.poll(
    f: StopPoll
): Ok = exec(f) as Ok

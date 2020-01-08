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
 * Sends a message
 * Returns the sent message
 *
 * @chatId - Target chat
 * @replyToMessageId - Identifier of the message to reply to or 0
 * @disableNotification - Pass true to disable notification for the message
 *                        Not supported in secret chats
 * @fromBackground - Pass true if the message is sent from the background
 * @replyMarkup - Markup for replying to the message
 * @inputMessageContent - The content of the message to be sent
 */
suspend fun TelegramClient.sendMessage(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    disableNotification: Boolean = false,
    fromBackground: Boolean = false,
    @BotsOnly replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null
): Message = message(
    SendMessage(
        chatId,
        replyToMessageId,
        disableNotification,
        fromBackground,
        replyMarkup,
        inputMessageContent
    )
)

/**
 * Sends a message
 * Returns the sent message
 */
suspend fun TelegramClient.message(
    f: SendMessage
): Message = exec(f) as Message

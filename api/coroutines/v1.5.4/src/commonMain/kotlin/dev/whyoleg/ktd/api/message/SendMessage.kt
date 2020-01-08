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
 * @options - Options to be used to send the message
 * @replyMarkup - Markup for replying to the message
 * @inputMessageContent - The content of the message to be sent
 */
suspend fun TelegramClient.sendMessage(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    options: SendMessageOptions? = null,
    @BotsOnly replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null
): Message = message(
    SendMessage(
        chatId,
        replyToMessageId,
        options,
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

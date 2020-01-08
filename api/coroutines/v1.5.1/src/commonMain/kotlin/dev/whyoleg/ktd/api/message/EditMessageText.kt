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
 * Edits the text of a message (or a text of a game message)
 * Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup
 * @inputMessageContent - New text content of the message
 *                        Should be of type InputMessageText
 */
suspend fun TelegramClient.editMessageText(
    chatId: Long = 0L,
    messageId: Long = 0L,
    @BotsOnly replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null
): Message = message(
    EditMessageText(
        chatId,
        messageId,
        replyMarkup,
        inputMessageContent
    )
)

/**
 * Edits the text of a message (or a text of a game message)
 * Returns the edited message after the edit is completed on the server side
 */
suspend fun TelegramClient.message(
    f: EditMessageText
): Message = exec(f) as Message

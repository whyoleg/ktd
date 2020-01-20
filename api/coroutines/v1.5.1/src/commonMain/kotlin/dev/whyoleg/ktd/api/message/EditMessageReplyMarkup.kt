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
 * Edits the message reply markup
 * Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup
 */
@BotsOnly
suspend fun TelegramClient.editMessageReplyMarkup(
    chatId: Long = 0L,
    messageId: Long = 0L,
    replyMarkup: ReplyMarkup? = null
): Message = message(
    EditMessageReplyMarkup(
        chatId,
        messageId,
        replyMarkup
    )
)

/**
 * Edits the message reply markup
 * Returns the edited message after the edit is completed on the server side
 */
@BotsOnly
suspend fun TelegramClient.message(
    f: EditMessageReplyMarkup
): Message = exec(f) as Message

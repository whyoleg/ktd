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
 * Edits the message content caption
 * Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup
 * @caption - New message content caption
 *            0-GetOption("message_caption_length_max") characters
 */
suspend fun TelegramClient.editMessageCaption(
    chatId: Long = 0L,
    messageId: Long = 0L,
    @BotsOnly replyMarkup: ReplyMarkup? = null,
    caption: FormattedText? = null
): Message = message(
    EditMessageCaption(
        chatId,
        messageId,
        replyMarkup,
        caption
    )
)

/**
 * Edits the message content caption
 * Returns the edited message after the edit is completed on the server side
 */
suspend fun TelegramClient.message(
    f: EditMessageCaption
): Message = exec(f) as Message

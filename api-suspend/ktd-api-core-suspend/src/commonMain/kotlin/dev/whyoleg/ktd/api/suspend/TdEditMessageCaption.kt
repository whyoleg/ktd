package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Edits the message content caption
 * Returns the edited message after the edit is completed on the server side
 *
 * @property chatId The chat the message belongs to
 * @property messageId Identifier of the message
 * @property replyMarkup The new message reply markup
 * @property caption New message content caption
 *                   0-GetOption("message_caption_length_max") characters
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.editMessageCaption(
    chatId: Long = 0L,
    messageId: Long = 0L,
    caption: TdFormattedText? = null,
    replyMarkup: TdReplyMarkup? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdMessage = exec(TdEditMessageCaption(chatId, messageId, caption, replyMarkup, extra))

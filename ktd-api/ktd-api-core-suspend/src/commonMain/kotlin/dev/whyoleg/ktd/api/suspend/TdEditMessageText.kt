package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Edits the text of a message (or a text of a game message)
 * Returns the edited message after the edit is completed on the server side
 *
 * @property chatId The chat the message belongs to
 * @property messageId Identifier of the message
 * @property replyMarkup The new message reply markup
 * @property inputMessageContent New text content of the message
 *                               Should be of type InputMessageText
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.editMessageText(
    chatId: Long = 0L,
    messageId: Long = 0L,
    inputMessageContent: TdInputMessageContent? = null,
    replyMarkup: TdReplyMarkup? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdMessage = exec(TdEditMessageText(chatId, messageId, inputMessageContent, replyMarkup, extra))

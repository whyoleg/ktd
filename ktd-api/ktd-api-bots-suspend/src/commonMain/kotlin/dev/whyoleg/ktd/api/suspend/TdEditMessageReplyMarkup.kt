package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Edits the message reply markup
 * Returns the edited message after the edit is completed on the server side
 *
 * @property chatId The chat the message belongs to
 * @property messageId Identifier of the message
 * @property replyMarkup The new message reply markup
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.editMessageReplyMarkup(
    chatId: Long = 0L,
    messageId: Long = 0L,
    replyMarkup: TdReplyMarkup? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdMessage = exec(TdEditMessageReplyMarkup(chatId, messageId, replyMarkup, extra))

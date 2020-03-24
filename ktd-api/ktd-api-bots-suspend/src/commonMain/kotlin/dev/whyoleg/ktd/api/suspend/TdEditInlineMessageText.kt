package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Edits the text of an inline text or game message sent via a bot
 *
 * @property inlineMessageId Inline message identifier
 * @property replyMarkup The new message reply markup
 * @property inputMessageContent New text content of the message
 *                               Should be of type InputMessageText
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.editInlineMessageText(
    inlineMessageId: String? = null,
    replyMarkup: TdReplyMarkup? = null,
    inputMessageContent: TdInputMessageContent? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdEditInlineMessageText(inlineMessageId, replyMarkup, inputMessageContent, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Edits the caption of an inline message sent via a bot
 *
 * @property inlineMessageId Inline message identifier
 * @property replyMarkup The new message reply markup
 * @property caption New message content caption
 *                   0-GetOption("message_caption_length_max") characters
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.editInlineMessageCaption(
    inlineMessageId: String? = null,
    replyMarkup: TdReplyMarkup? = null,
    caption: TdFormattedText? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdEditInlineMessageCaption(inlineMessageId, replyMarkup, caption, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Edits the reply markup of an inline message sent via a bot
 *
 * @property inlineMessageId Inline message identifier
 * @property replyMarkup The new message reply markup
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.editInlineMessageReplyMarkup(
    inlineMessageId: String? = null,
    replyMarkup: TdReplyMarkup? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdEditInlineMessageReplyMarkup(inlineMessageId, replyMarkup, extra))

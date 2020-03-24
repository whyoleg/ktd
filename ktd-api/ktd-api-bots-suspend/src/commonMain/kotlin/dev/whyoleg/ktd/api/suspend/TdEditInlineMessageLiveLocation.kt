package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Edits the content of a live location in an inline message sent via a bot
 *
 * @property inlineMessageId Inline message identifier
 * @property replyMarkup The new message reply markup
 * @property location New location content of the message
 *                    Pass null to stop sharing the live location
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.editInlineMessageLiveLocation(
    inlineMessageId: String? = null,
    replyMarkup: TdReplyMarkup? = null,
    location: TdLocation? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdEditInlineMessageLiveLocation(inlineMessageId, replyMarkup, location, extra))

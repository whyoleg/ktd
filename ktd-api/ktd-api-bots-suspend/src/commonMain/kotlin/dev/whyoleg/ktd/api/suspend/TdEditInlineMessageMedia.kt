package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Edits the content of a message with an animation, an audio, a document, a photo or a video in an inline message sent via a bot
 *
 * @property inlineMessageId Inline message identifier
 * @property replyMarkup The new message reply markup
 * @property inputMessageContent New content of the message
 *                               Must be one of the following types: InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or InputMessageVideo
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.editInlineMessageMedia(
    inlineMessageId: String? = null,
    inputMessageContent: TdInputMessageContent? = null,
    replyMarkup: TdReplyMarkup? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdEditInlineMessageMedia(inlineMessageId, inputMessageContent, replyMarkup, extra))

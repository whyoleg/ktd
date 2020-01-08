@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.inline

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Edits the content of a message with an animation, an audio, a document, a photo or a video in an inline message sent via a bot
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 * @inputMessageContent - New content of the message
 *                        Must be one of the following types: InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or InputMessageVideo
 */
@BotsOnly
suspend fun TelegramClient.editInlineMessageMedia(
    inlineMessageId: String? = null,
    @BotsOnly replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null
): Ok = inline(
    EditInlineMessageMedia(
        inlineMessageId,
        replyMarkup,
        inputMessageContent
    )
)

/**
 * Edits the content of a message with an animation, an audio, a document, a photo or a video in an inline message sent via a bot
 */
@BotsOnly
suspend fun TelegramClient.inline(
    f: EditInlineMessageMedia
): Ok = exec(f) as Ok

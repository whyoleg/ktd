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
 * Edits the caption of an inline message sent via a bot
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 * @caption - New message content caption
 *            0-GetOption("message_caption_length_max") characters
 */
@BotsOnly
suspend fun TelegramClient.editInlineMessageCaption(
    inlineMessageId: String? = null,
    replyMarkup: ReplyMarkup? = null,
    caption: FormattedText? = null
): Ok = inline(
    EditInlineMessageCaption(
        inlineMessageId,
        replyMarkup,
        caption
    )
)

/**
 * Edits the caption of an inline message sent via a bot
 */
@BotsOnly
suspend fun TelegramClient.inline(
    f: EditInlineMessageCaption
): Ok = exec(f) as Ok

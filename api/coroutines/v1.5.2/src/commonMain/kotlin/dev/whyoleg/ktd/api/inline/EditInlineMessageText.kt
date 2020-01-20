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
 * Edits the text of an inline text or game message sent via a bot
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 * @inputMessageContent - New text content of the message
 *                        Should be of type InputMessageText
 */
@BotsOnly
suspend fun TelegramClient.editInlineMessageText(
    inlineMessageId: String? = null,
    replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null
): Ok = inline(
    EditInlineMessageText(
        inlineMessageId,
        replyMarkup,
        inputMessageContent
    )
)

/**
 * Edits the text of an inline text or game message sent via a bot
 */
@BotsOnly
suspend fun TelegramClient.inline(
    f: EditInlineMessageText
): Ok = exec(f) as Ok

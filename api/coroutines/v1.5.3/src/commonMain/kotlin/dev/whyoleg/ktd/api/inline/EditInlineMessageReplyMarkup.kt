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
 * Edits the reply markup of an inline message sent via a bot
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 */
@BotsOnly
suspend fun TelegramClient.editInlineMessageReplyMarkup(
    inlineMessageId: String? = null,
    replyMarkup: ReplyMarkup? = null
): Ok = inline(
    EditInlineMessageReplyMarkup(
        inlineMessageId,
        replyMarkup
    )
)

/**
 * Edits the reply markup of an inline message sent via a bot
 */
@BotsOnly
suspend fun TelegramClient.inline(
    f: EditInlineMessageReplyMarkup
): Ok = exec(f) as Ok

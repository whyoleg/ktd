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
 * Edits the content of a live location in an inline message sent via a bot
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 * @location - New location content of the message
 *             Pass null to stop sharing the live location
 */
@BotsOnly
suspend fun TelegramClient.editInlineMessageLiveLocation(
    inlineMessageId: String? = null,
    replyMarkup: ReplyMarkup? = null,
    location: Location? = null
): Ok = inline(
    EditInlineMessageLiveLocation(
        inlineMessageId,
        replyMarkup,
        location
    )
)

/**
 * Edits the content of a live location in an inline message sent via a bot
 */
@BotsOnly
suspend fun TelegramClient.inline(
    f: EditInlineMessageLiveLocation
): Ok = exec(f) as Ok

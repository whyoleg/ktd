@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.text

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the default text for invitation messages to be used as a placeholder when the current user invites friends to Telegram
 */
suspend fun TelegramClient.getInviteText(): Text = text(
    GetInviteText()
)

/**
 * Returns the default text for invitation messages to be used as a placeholder when the current user invites friends to Telegram
 */
suspend fun TelegramClient.text(
    f: GetInviteText
): Text = exec(f) as Text

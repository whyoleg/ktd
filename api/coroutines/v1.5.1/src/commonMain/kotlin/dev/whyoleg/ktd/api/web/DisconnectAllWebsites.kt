@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.web

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Disconnects all websites from the current user's Telegram account
 */
suspend fun TelegramClient.disconnectAllWebsites(): Ok = web(
    DisconnectAllWebsites()
)

/**
 * Disconnects all websites from the current user's Telegram account
 */
suspend fun TelegramClient.web(
    f: DisconnectAllWebsites
): Ok = exec(f) as Ok

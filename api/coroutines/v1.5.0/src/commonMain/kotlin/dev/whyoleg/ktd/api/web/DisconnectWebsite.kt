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
 * Disconnects website from the current user's Telegram account
 *
 * @websiteId - Website identifier
 */
suspend fun TelegramClient.disconnectWebsite(
    websiteId: Long = 0L
): Ok = web(
    DisconnectWebsite(
        websiteId
    )
)

/**
 * Disconnects website from the current user's Telegram account
 */
suspend fun TelegramClient.web(
    f: DisconnectWebsite
): Ok = exec(f) as Ok

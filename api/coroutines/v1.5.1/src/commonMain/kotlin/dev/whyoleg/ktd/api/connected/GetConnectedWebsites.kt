@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.connected

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns all website where the current user used Telegram to log in
 */
suspend fun TelegramClient.getConnectedWebsites(): ConnectedWebsites = connected(
    GetConnectedWebsites()
)

/**
 * Returns all website where the current user used Telegram to log in
 */
suspend fun TelegramClient.connected(
    f: GetConnectedWebsites
): ConnectedWebsites = exec(f) as ConnectedWebsites

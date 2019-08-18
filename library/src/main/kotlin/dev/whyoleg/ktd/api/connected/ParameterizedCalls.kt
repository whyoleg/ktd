@file:Suppress("unused")

package dev.whyoleg.ktd.api.connected

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns all website where the current user used Telegram to log in
 */
suspend fun TelegramClient.getConnectedWebsites(): ConnectedWebsites = connected(
    GetConnectedWebsites()
)

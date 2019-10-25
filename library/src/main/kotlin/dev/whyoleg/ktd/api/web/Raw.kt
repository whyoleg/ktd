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
 * Returns a web page preview by the text of the message
 * Do not call this function too often
 * Returns a 404 error if the web page has no preview
 */
suspend fun TelegramClient.web(
    f: GetWebPagePreview
): WebPage = execRaw(f) as WebPage

/**
 * Returns an instant view version of a web page if available
 * Returns a 404 error if the web page has no instant view page
 */
suspend fun TelegramClient.web(
    f: GetWebPageInstantView
): WebPageInstantView = execRaw(f) as WebPageInstantView

/**
 * Disconnects website from the current user's Telegram account
 */
suspend fun TelegramClient.web(
    f: DisconnectWebsite
): Ok = execRaw(f) as Ok

/**
 * Disconnects all websites from the current user's Telegram account
 */
suspend fun TelegramClient.web(
    f: DisconnectAllWebsites
): Ok = execRaw(f) as Ok

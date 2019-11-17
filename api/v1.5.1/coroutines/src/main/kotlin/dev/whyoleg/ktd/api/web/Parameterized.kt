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
 *
 * @text - Message text with formatting
 */
suspend fun TelegramClient.getWebPagePreview(
    text: FormattedText
): WebPage = web(
    GetWebPagePreview(
        text
    )
)

/**
 * Returns an instant view version of a web page if available
 * Returns a 404 error if the web page has no instant view page
 *
 * @url - The web page URL
 * @forceFull - If true, the full instant view for the web page will be returned
 */
suspend fun TelegramClient.getWebPageInstantView(
    url: String,
    forceFull: Boolean = false
): WebPageInstantView = web(
    GetWebPageInstantView(
        url,
        forceFull
    )
)

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
 * Disconnects all websites from the current user's Telegram account
 */
suspend fun TelegramClient.disconnectAllWebsites(): Ok = web(
    DisconnectAllWebsites()
)

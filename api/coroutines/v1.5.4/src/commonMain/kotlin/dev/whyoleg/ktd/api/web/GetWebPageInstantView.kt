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
 * Returns an instant view version of a web page if available
 * Returns a 404 error if the web page has no instant view page
 *
 * @url - The web page URL
 * @forceFull - If true, the full instant view for the web page will be returned
 */
suspend fun TelegramClient.getWebPageInstantView(
    url: String? = null,
    forceFull: Boolean = false
): WebPageInstantView = web(
    GetWebPageInstantView(
        url,
        forceFull
    )
)

/**
 * Returns an instant view version of a web page if available
 * Returns a 404 error if the web page has no instant view page
 */
suspend fun TelegramClient.web(
    f: GetWebPageInstantView
): WebPageInstantView = exec(f) as WebPageInstantView

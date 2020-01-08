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
    text: FormattedText? = null
): WebPage = web(
    GetWebPagePreview(
        text
    )
)

/**
 * Returns a web page preview by the text of the message
 * Do not call this function too often
 * Returns a 404 error if the web page has no preview
 */
suspend fun TelegramClient.web(
    f: GetWebPagePreview
): WebPage = exec(f) as WebPage

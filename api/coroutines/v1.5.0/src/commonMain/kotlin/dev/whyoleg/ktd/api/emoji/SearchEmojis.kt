@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.emoji

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Searches for emojis by keywords
 * Supported only if the file database is enabled
 *
 * @text - Text to search for
 * @exactMatch - True, if only emojis, which exactly match text needs to be returned
 */
suspend fun TelegramClient.searchEmojis(
    text: String? = null,
    exactMatch: Boolean = false
): Emojis = emoji(
    SearchEmojis(
        text,
        exactMatch
    )
)

/**
 * Searches for emojis by keywords
 * Supported only if the file database is enabled
 */
suspend fun TelegramClient.emoji(
    f: SearchEmojis
): Emojis = exec(f) as Emojis

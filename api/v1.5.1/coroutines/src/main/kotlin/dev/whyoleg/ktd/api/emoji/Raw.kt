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
 * Returns emoji corresponding to a sticker
 * The list is only for informational purposes, because a sticker is always sent with a fixed emoji from the corresponding Sticker object
 */
suspend fun TelegramClient.emoji(
    f: GetStickerEmojis
): Emojis = exec(f) as Emojis

/**
 * Searches for emojis by keywords
 * Supported only if the file database is enabled
 */
suspend fun TelegramClient.emoji(
    f: SearchEmojis
): Emojis = exec(f) as Emojis

/**
 * Returns an HTTP URL which can be used to automatically log in to the translation platform and suggest new emoji replacements
 * The URL will be valid for 30 seconds after generation
 */
suspend fun TelegramClient.emoji(
    f: GetEmojiSuggestionsUrl
): HttpUrl = exec(f) as HttpUrl

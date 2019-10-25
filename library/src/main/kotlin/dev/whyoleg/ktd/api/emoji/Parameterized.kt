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
 *
 * @sticker - Sticker file identifier
 */
suspend fun TelegramClient.getStickerEmojis(
    sticker: InputFile? = null
): Emojis = emoji(
    GetStickerEmojis(
        sticker
    )
)

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
 * Returns an HTTP URL which can be used to automatically log in to the translation platform and suggest new emoji replacements
 * The URL will be valid for 30 seconds after generation
 *
 * @languageCode - Language code for which the emoji replacements will be suggested
 */
suspend fun TelegramClient.getEmojiSuggestionsUrl(
    languageCode: String? = null
): HttpUrl = emoji(
    GetEmojiSuggestionsUrl(
        languageCode
    )
)

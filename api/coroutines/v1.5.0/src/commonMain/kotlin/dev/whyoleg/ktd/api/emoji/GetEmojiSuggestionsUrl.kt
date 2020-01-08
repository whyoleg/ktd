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

/**
 * Returns an HTTP URL which can be used to automatically log in to the translation platform and suggest new emoji replacements
 * The URL will be valid for 30 seconds after generation
 */
suspend fun TelegramClient.emoji(
    f: GetEmojiSuggestionsUrl
): HttpUrl = exec(f) as HttpUrl

@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.language

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns strings from a language pack in the current localization target by their keys
 * Can be called before authorization
 *
 * @languagePackId - Language pack identifier of the strings to be returned
 * @keys - Language pack keys of the strings to be returned
 *         Leave empty to request all available strings
 */
suspend fun TelegramClient.getLanguagePackStrings(
    languagePackId: String? = null,
    keys: Array<String> = emptyArray()
): LanguagePackStrings = language(
    GetLanguagePackStrings(
        languagePackId,
        keys
    )
)

/**
 * Returns strings from a language pack in the current localization target by their keys
 * Can be called before authorization
 */
suspend fun TelegramClient.language(
    f: GetLanguagePackStrings
): LanguagePackStrings = exec(f) as LanguagePackStrings

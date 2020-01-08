@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.custom

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Adds or changes a custom local language pack to the current localization target
 *
 * @info - Information about the language pack
 *         Language pack ID must start with 'X', consist only of English letters, digits and hyphens, and must not exceed 64 characters
 *         Can be called before authorization
 * @strings - Strings of the new language pack
 */
suspend fun TelegramClient.setCustomLanguagePack(
    info: LanguagePackInfo? = null,
    strings: Array<LanguagePackString> = emptyArray()
): Ok = custom(
    SetCustomLanguagePack(
        info,
        strings
    )
)

/**
 * Adds or changes a custom local language pack to the current localization target
 */
suspend fun TelegramClient.custom(
    f: SetCustomLanguagePack
): Ok = exec(f) as Ok

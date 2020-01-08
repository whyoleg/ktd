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
 * Adds, edits or deletes a string in a custom local language pack
 * Can be called before authorization
 *
 * @languagePackId - Identifier of a previously added custom local language pack in the current localization target
 * @newString - New language pack string
 */
suspend fun TelegramClient.setCustomLanguagePackString(
    languagePackId: String? = null,
    newString: LanguagePackString? = null
): Ok = custom(
    SetCustomLanguagePackString(
        languagePackId,
        newString
    )
)

/**
 * Adds, edits or deletes a string in a custom local language pack
 * Can be called before authorization
 */
suspend fun TelegramClient.custom(
    f: SetCustomLanguagePackString
): Ok = exec(f) as Ok

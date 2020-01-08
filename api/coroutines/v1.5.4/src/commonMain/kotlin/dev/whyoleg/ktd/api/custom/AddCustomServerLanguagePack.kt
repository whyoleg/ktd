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
 * Adds a custom server language pack to the list of installed language packs in current localization target
 * Can be called before authorization
 *
 * @languagePackId - Identifier of a language pack to be added
 *                   May be different from a name that is used in an "https://t.me/setlanguage/" link
 */
suspend fun TelegramClient.addCustomServerLanguagePack(
    languagePackId: String? = null
): Ok = custom(
    AddCustomServerLanguagePack(
        languagePackId
    )
)

/**
 * Adds a custom server language pack to the list of installed language packs in current localization target
 * Can be called before authorization
 */
suspend fun TelegramClient.custom(
    f: AddCustomServerLanguagePack
): Ok = exec(f) as Ok

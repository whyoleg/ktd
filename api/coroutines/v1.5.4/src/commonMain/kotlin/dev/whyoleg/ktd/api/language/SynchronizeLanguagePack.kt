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
 * Fetches the latest versions of all strings from a language pack in the current localization target from the server
 * This method doesn't need to be called explicitly for the current used/base language packs
 * Can be called before authorization
 *
 * @languagePackId - Language pack identifier
 */
suspend fun TelegramClient.synchronizeLanguagePack(
    languagePackId: String? = null
): Ok = language(
    SynchronizeLanguagePack(
        languagePackId
    )
)

/**
 * Fetches the latest versions of all strings from a language pack in the current localization target from the server
 * This method doesn't need to be called explicitly for the current used/base language packs
 * Can be called before authorization
 */
suspend fun TelegramClient.language(
    f: SynchronizeLanguagePack
): Ok = exec(f) as Ok

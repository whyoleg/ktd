@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.sync

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a string stored in the local database from the specified localization target and language pack by its key
 * Returns a 404 error if the string is not found
 * This is an offline method
 * Can be called before authorization
 *
 * @languagePackDatabasePath - Path to the language pack database in which strings are stored
 * @localizationTarget - Localization target to which the language pack belongs
 * @languagePackId - Language pack identifier
 * @key - Language pack key of the string to be returned
 */
suspend fun TelegramClient.getLanguagePackString(
    languagePackDatabasePath: String? = null,
    localizationTarget: String? = null,
    languagePackId: String? = null,
    key: String? = null
): LanguagePackStringValue = sync(
    GetLanguagePackString(
        languagePackDatabasePath,
        localizationTarget,
        languagePackId,
        key
    )
)

/**
 * Returns a string stored in the local database from the specified localization target and language pack by its key
 * Returns a 404 error if the string is not found
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.sync(
    f: GetLanguagePackString
): LanguagePackStringValue = exec(f) as LanguagePackStringValue

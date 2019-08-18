@file:Suppress("unused")

package dev.whyoleg.ktd.api.language

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a string stored in the local database from the specified localization target and language pack by its key. Returns a 404 error if the string is not found. This is an offline method. Can be called before authorization. Can be called synchronously
 *
 * @languagePackDatabasePath - Path to the language pack database in which strings are stored
 * @localizationTarget - Localization target to which the language pack belongs
 * @languagePackId - Language pack identifier
 * @key - Language pack key of the string to be returned
 */
suspend fun TelegramClient.getLanguagePackString(
    languagePackDatabasePath: String,
    localizationTarget: String,
    languagePackId: String,
    key: String
): LanguagePackStringValue = language(
    GetLanguagePackString(
        languagePackDatabasePath,
        localizationTarget,
        languagePackId,
        key
    )
)

/**
 * Returns information about a language pack. Returned language pack identifier may be different from a provided one. Can be called before authorization
 *
 * @languagePackId - Language pack identifier
 */
suspend fun TelegramClient.getLanguagePackInfo(
    languagePackId: String
): LanguagePackInfo = language(
    GetLanguagePackInfo(
        languagePackId
    )
)

/**
 * Returns strings from a language pack in the current localization target by their keys. Can be called before authorization
 *
 * @languagePackId - Language pack identifier of the strings to be returned
 * @keys - Language pack keys of the strings to be returned; leave empty to request all available strings
 */
suspend fun TelegramClient.getLanguagePackStrings(
    languagePackId: String,
    keys: Array<String>
): LanguagePackStrings = language(
    GetLanguagePackStrings(
        languagePackId,
        keys
    )
)

/**
 * Fetches the latest versions of all strings from a language pack in the current localization target from the server. This method doesn't need to be called explicitly for the current used/base language packs. Can be called before authorization
 *
 * @languagePackId - Language pack identifier
 */
suspend fun TelegramClient.synchronizeLanguagePack(
    languagePackId: String
): Ok = language(
    SynchronizeLanguagePack(
        languagePackId
    )
)

/**
 * Deletes all information about a language pack in the current localization target. The language pack which is currently in use (including base language pack) or is being synchronized can't be deleted. Can be called before authorization
 *
 * @languagePackId - Identifier of the language pack to delete
 */
suspend fun TelegramClient.deleteLanguagePack(
    languagePackId: String
): Ok = language(
    DeleteLanguagePack(
        languagePackId
    )
)

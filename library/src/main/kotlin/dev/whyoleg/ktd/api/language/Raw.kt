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
 * Returns a string stored in the local database from the specified localization target and language pack by its key
 * Returns a 404 error if the string is not found
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
suspend fun TelegramClient.language(
    f: GetLanguagePackString
): LanguagePackStringValue = execRaw(f) as LanguagePackStringValue

/**
 * Returns information about a language pack
 * Returned language pack identifier may be different from a provided one
 * Can be called before authorization
 */
suspend fun TelegramClient.language(
    f: GetLanguagePackInfo
): LanguagePackInfo = execRaw(f) as LanguagePackInfo

/**
 * Returns strings from a language pack in the current localization target by their keys
 * Can be called before authorization
 */
suspend fun TelegramClient.language(
    f: GetLanguagePackStrings
): LanguagePackStrings = execRaw(f) as LanguagePackStrings

/**
 * Fetches the latest versions of all strings from a language pack in the current localization target from the server
 * This method doesn't need to be called explicitly for the current used/base language packs
 * Can be called before authorization
 */
suspend fun TelegramClient.language(
    f: SynchronizeLanguagePack
): Ok = execRaw(f) as Ok

/**
 * Deletes all information about a language pack in the current localization target
 * The language pack which is currently in use (including base language pack) or is being synchronized can't be deleted
 * Can be called before authorization
 */
suspend fun TelegramClient.language(
    f: DeleteLanguagePack
): Ok = execRaw(f) as Ok

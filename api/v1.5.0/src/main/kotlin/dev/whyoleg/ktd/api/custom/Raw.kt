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
 */
suspend fun TelegramClient.custom(
    f: AddCustomServerLanguagePack
): Ok = exec(f) as Ok

/**
 * Adds or changes a custom local language pack to the current localization target
 */
suspend fun TelegramClient.custom(
    f: SetCustomLanguagePack
): Ok = exec(f) as Ok

/**
 * Edits information about a custom local language pack in the current localization target
 * Can be called before authorization
 */
suspend fun TelegramClient.custom(
    f: EditCustomLanguagePackInfo
): Ok = exec(f) as Ok

/**
 * Adds, edits or deletes a string in a custom local language pack
 * Can be called before authorization
 */
suspend fun TelegramClient.custom(
    f: SetCustomLanguagePackString
): Ok = exec(f) as Ok

/**
 * Sends a custom request
 */
@BotsOnly
suspend fun TelegramClient.custom(
    f: SendCustomRequest
): CustomRequestResult = exec(f) as CustomRequestResult

/**
 * Answers a custom query
 */
@BotsOnly
suspend fun TelegramClient.custom(
    f: AnswerCustomQuery
): Ok = exec(f) as Ok

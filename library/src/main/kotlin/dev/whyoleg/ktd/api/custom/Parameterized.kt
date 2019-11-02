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
    languagePackId: String
): Ok = custom(
    AddCustomServerLanguagePack(
        languagePackId
    )
)

/**
 * Adds or changes a custom local language pack to the current localization target
 *
 * @info - Information about the language pack
 *         Language pack ID must start with 'X', consist only of English letters, digits and hyphens, and must not exceed 64 characters
 *         Can be called before authorization
 * @strings - Strings of the new language pack
 */
suspend fun TelegramClient.setCustomLanguagePack(
    info: LanguagePackInfo,
    strings: Array<LanguagePackString> = emptyArray()
): Ok = custom(
    SetCustomLanguagePack(
        info,
        strings
    )
)

/**
 * Edits information about a custom local language pack in the current localization target
 * Can be called before authorization
 *
 * @info - New information about the custom local language pack
 */
suspend fun TelegramClient.editCustomLanguagePackInfo(
    info: LanguagePackInfo
): Ok = custom(
    EditCustomLanguagePackInfo(
        info
    )
)

/**
 * Adds, edits or deletes a string in a custom local language pack
 * Can be called before authorization
 *
 * @languagePackId - Identifier of a previously added custom local language pack in the current localization target
 * @newString - New language pack string
 */
suspend fun TelegramClient.setCustomLanguagePackString(
    languagePackId: String,
    newString: LanguagePackString
): Ok = custom(
    SetCustomLanguagePackString(
        languagePackId,
        newString
    )
)

/**
 * Sends a custom request
 *
 * @method - The method name
 * @parameters - JSON-serialized method parameters
 */
@BotsOnly
suspend fun TelegramClient.sendCustomRequest(
    method: String,
    parameters: String
): CustomRequestResult = custom(
    SendCustomRequest(
        method,
        parameters
    )
)

/**
 * Answers a custom query
 *
 * @customQueryId - Identifier of a custom query
 * @data - JSON-serialized answer to the query
 */
@BotsOnly
suspend fun TelegramClient.answerCustomQuery(
    customQueryId: Long = 0L,
    data: String
): Ok = custom(
    AnswerCustomQuery(
        customQueryId,
        data
    )
)

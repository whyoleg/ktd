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
 * Deletes all information about a language pack in the current localization target
 * The language pack which is currently in use (including base language pack) or is being synchronized can't be deleted
 * Can be called before authorization
 *
 * @languagePackId - Identifier of the language pack to delete
 */
suspend fun TelegramClient.deleteLanguagePack(
    languagePackId: String? = null
): Ok = language(
    DeleteLanguagePack(
        languagePackId
    )
)

/**
 * Deletes all information about a language pack in the current localization target
 * The language pack which is currently in use (including base language pack) or is being synchronized can't be deleted
 * Can be called before authorization
 */
suspend fun TelegramClient.language(
    f: DeleteLanguagePack
): Ok = exec(f) as Ok

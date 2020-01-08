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
 * Returns information about a language pack
 * Returned language pack identifier may be different from a provided one
 * Can be called before authorization
 *
 * @languagePackId - Language pack identifier
 */
suspend fun TelegramClient.getLanguagePackInfo(
    languagePackId: String? = null
): LanguagePackInfo = language(
    GetLanguagePackInfo(
        languagePackId
    )
)

/**
 * Returns information about a language pack
 * Returned language pack identifier may be different from a provided one
 * Can be called before authorization
 */
suspend fun TelegramClient.language(
    f: GetLanguagePackInfo
): LanguagePackInfo = exec(f) as LanguagePackInfo

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
 * Edits information about a custom local language pack in the current localization target
 * Can be called before authorization
 *
 * @info - New information about the custom local language pack
 */
suspend fun TelegramClient.editCustomLanguagePackInfo(
    info: LanguagePackInfo? = null
): Ok = custom(
    EditCustomLanguagePackInfo(
        info
    )
)

/**
 * Edits information about a custom local language pack in the current localization target
 * Can be called before authorization
 */
suspend fun TelegramClient.custom(
    f: EditCustomLanguagePackInfo
): Ok = exec(f) as Ok

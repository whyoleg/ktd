@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.background

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns backgrounds installed by the user
 *
 * @forDarkTheme - True, if the backgrounds needs to be ordered for dark theme
 */
suspend fun TelegramClient.getBackgrounds(
    forDarkTheme: Boolean = false
): Backgrounds = background(
    GetBackgrounds(
        forDarkTheme
    )
)

/**
 * Returns backgrounds installed by the user
 */
suspend fun TelegramClient.background(
    f: GetBackgrounds
): Backgrounds = exec(f) as Backgrounds

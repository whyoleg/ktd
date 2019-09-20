@file:Suppress("unused")

package dev.whyoleg.ktd.api.backgrounds

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns backgrounds installed by the user
 *
 * @forDarkTheme - True, if the backgrounds needs to be ordered for dark theme
 */
suspend fun TelegramClient.getBackgrounds(
    forDarkTheme: Boolean
): Backgrounds = backgrounds(
    GetBackgrounds(
        forDarkTheme
    )
)

/**
 * Resets list of installed backgrounds to its default value
 */
suspend fun TelegramClient.resetBackgrounds(): Ok = backgrounds(
    ResetBackgrounds()
)

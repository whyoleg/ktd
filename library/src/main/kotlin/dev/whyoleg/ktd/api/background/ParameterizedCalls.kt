@file:Suppress("unused")

package dev.whyoleg.ktd.api.background

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Searches for a background by its name
 *
 * @name - The name of the background
 */
suspend fun TelegramClient.searchBackground(
    name: String
): Background = background(
    SearchBackground(
        name
    )
)

/**
 * Changes the background selected by the user; adds background to the list of installed backgrounds
 *
 * @background - The input background to use, null for solid backgrounds
 * @type - Background type; null for default background. The method will return error 404 if type is null
 * @forDarkTheme - True, if the background is chosen for dark theme
 */
suspend fun TelegramClient.setBackground(
    background: InputBackground,
    type: BackgroundType,
    forDarkTheme: Boolean
): Background = background(
    SetBackground(
        background,
        type,
        forDarkTheme
    )
)

/**
 * Removes background from the list of installed backgrounds
 *
 * @backgroundId - The background indentifier
 */
suspend fun TelegramClient.removeBackground(
    backgroundId: Long
): Ok = background(
    RemoveBackground(
        backgroundId
    )
)

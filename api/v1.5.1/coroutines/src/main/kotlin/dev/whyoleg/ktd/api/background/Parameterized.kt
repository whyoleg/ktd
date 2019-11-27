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
 * Constructs a persistent HTTP URL for a background
 *
 * @name - Background name
 * @type - Background type
 */
suspend fun TelegramClient.getBackgroundUrl(
    name: String? = null,
    type: BackgroundType? = null
): HttpUrl = background(
    GetBackgroundUrl(
        name,
        type
    )
)

/**
 * Searches for a background by its name
 *
 * @name - The name of the background
 */
suspend fun TelegramClient.searchBackground(
    name: String? = null
): Background = background(
    SearchBackground(
        name
    )
)

/**
 * Changes the background selected by the user
 * Adds background to the list of installed backgrounds
 *
 * @background - The input background to use, null for solid backgrounds
 * @type - Background type
 *         Null for default background
 *         The method will return error 404 if type is null
 * @forDarkTheme - True, if the background is chosen for dark theme
 */
suspend fun TelegramClient.setBackground(
    background: InputBackground? = null,
    type: BackgroundType? = null,
    forDarkTheme: Boolean = false
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
    backgroundId: Long = 0L
): Ok = background(
    RemoveBackground(
        backgroundId
    )
)

/**
 * Resets list of installed backgrounds to its default value
 */
suspend fun TelegramClient.resetBackgrounds(): Ok = background(
    ResetBackgrounds()
)

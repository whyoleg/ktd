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
 * Changes the background selected by the user
 * Adds background to the list of installed backgrounds
 */
suspend fun TelegramClient.background(
    f: SetBackground
): Background = exec(f) as Background

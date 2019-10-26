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
 */
suspend fun TelegramClient.background(
    f: GetBackgrounds
): Backgrounds = execRaw(f) as Backgrounds

/**
 * Constructs a persistent HTTP URL for a background
 */
suspend fun TelegramClient.background(
    f: GetBackgroundUrl
): HttpUrl = execRaw(f) as HttpUrl

/**
 * Searches for a background by its name
 */
suspend fun TelegramClient.background(
    f: SearchBackground
): Background = execRaw(f) as Background

/**
 * Changes the background selected by the user
 * Adds background to the list of installed backgrounds
 */
suspend fun TelegramClient.background(
    f: SetBackground
): Background = execRaw(f) as Background

/**
 * Removes background from the list of installed backgrounds
 */
suspend fun TelegramClient.background(
    f: RemoveBackground
): Ok = execRaw(f) as Ok

/**
 * Resets list of installed backgrounds to its default value
 */
suspend fun TelegramClient.background(
    f: ResetBackgrounds
): Ok = execRaw(f) as Ok

@file:Suppress("unused")

package dev.whyoleg.ktd.api.background

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Searches for a background by its name
 */
suspend fun TelegramClient.background(
    f: SearchBackground
): Background = execRaw(f) as Background

/**
 * Changes the background selected by the user; adds background to the list of installed backgrounds
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

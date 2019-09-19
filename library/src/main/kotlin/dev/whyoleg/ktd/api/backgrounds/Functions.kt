@file:Suppress("unused")

package dev.whyoleg.ktd.api.backgrounds

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns backgrounds installed by the user
 */
suspend fun TelegramClient.backgrounds(
    f: GetBackgrounds
): Backgrounds = execRaw(f) as Backgrounds

/**
 * Resets list of installed backgrounds to its default value
 */
suspend fun TelegramClient.backgrounds(
    f: ResetBackgrounds
): Ok = execRaw(f) as Ok

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
 * Resets list of installed backgrounds to its default value
 */
suspend fun TelegramClient.resetBackgrounds(): Ok = background(
    ResetBackgrounds()
)

/**
 * Resets list of installed backgrounds to its default value
 */
suspend fun TelegramClient.background(
    f: ResetBackgrounds
): Ok = exec(f) as Ok

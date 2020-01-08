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
 * Removes background from the list of installed backgrounds
 */
suspend fun TelegramClient.background(
    f: RemoveBackground
): Ok = exec(f) as Ok

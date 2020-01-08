@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.animation

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Removes an animation from the list of saved animations
 *
 * @animation - Animation file to be removed
 */
suspend fun TelegramClient.removeSavedAnimation(
    animation: InputFile? = null
): Ok = animation(
    RemoveSavedAnimation(
        animation
    )
)

/**
 * Removes an animation from the list of saved animations
 */
suspend fun TelegramClient.animation(
    f: RemoveSavedAnimation
): Ok = exec(f) as Ok

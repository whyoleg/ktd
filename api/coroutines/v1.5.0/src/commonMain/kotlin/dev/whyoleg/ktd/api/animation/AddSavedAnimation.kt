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
 * Manually adds a new animation to the list of saved animations
 * The new animation is added to the beginning of the list
 * If the animation was already in the list, it is removed first
 * Only non-secret video animations with MIME type "video/mp4" can be added to the list
 *
 * @animation - The animation file to be added
 *              Only animations known to the server (i.e
 *              Successfully sent via a message) can be added to the list
 */
suspend fun TelegramClient.addSavedAnimation(
    animation: InputFile? = null
): Ok = animation(
    AddSavedAnimation(
        animation
    )
)

/**
 * Manually adds a new animation to the list of saved animations
 * The new animation is added to the beginning of the list
 * If the animation was already in the list, it is removed first
 * Only non-secret video animations with MIME type "video/mp4" can be added to the list
 */
suspend fun TelegramClient.animation(
    f: AddSavedAnimation
): Ok = exec(f) as Ok

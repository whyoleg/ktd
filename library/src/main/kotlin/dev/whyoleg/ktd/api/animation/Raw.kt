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
 * Returns saved animations
 */
suspend fun TelegramClient.animation(
    f: GetSavedAnimations
): Animations = execRaw(f) as Animations

/**
 * Manually adds a new animation to the list of saved animations
 * The new animation is added to the beginning of the list
 * If the animation was already in the list, it is removed first
 * Only non-secret video animations with MIME type "video/mp4" can be added to the list
 */
suspend fun TelegramClient.animation(
    f: AddSavedAnimation
): Ok = execRaw(f) as Ok

/**
 * Removes an animation from the list of saved animations
 */
suspend fun TelegramClient.animation(
    f: RemoveSavedAnimation
): Ok = execRaw(f) as Ok

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
suspend fun TelegramClient.getSavedAnimations(): Animations = animation(
    GetSavedAnimations()
)

/**
 * Returns saved animations
 */
suspend fun TelegramClient.animation(
    f: GetSavedAnimations
): Animations = exec(f) as Animations

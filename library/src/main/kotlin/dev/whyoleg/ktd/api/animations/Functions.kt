@file:Suppress("unused")

package dev.whyoleg.ktd.api.animations

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns saved animations
 */
suspend fun TelegramClient.animations(
    f: GetSavedAnimations
): Animations = execRaw(f) as Animations

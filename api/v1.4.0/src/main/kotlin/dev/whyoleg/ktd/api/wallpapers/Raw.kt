@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.wallpapers

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns background wallpapers
 */
suspend fun TelegramClient.wallpapers(
    f: GetWallpapers
): Wallpapers = exec(f) as Wallpapers

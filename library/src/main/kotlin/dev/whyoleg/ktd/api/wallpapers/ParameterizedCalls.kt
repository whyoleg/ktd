@file:Suppress("unused")

package dev.whyoleg.ktd.api.wallpapers

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns background wallpapers
 */
suspend fun TelegramClient.getWallpapers(): Wallpapers = wallpapers(
    GetWallpapers()
)

@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.sticker

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a list of recently used stickers
 *
 * @isAttached - Pass true to return stickers and masks that were recently attached to photos or video files
 *               Pass false to return recently sent stickers
 */
suspend fun TelegramClient.getRecentStickers(
    isAttached: Boolean = false
): Stickers = sticker(
    GetRecentStickers(
        isAttached
    )
)

/**
 * Returns a list of recently used stickers
 */
suspend fun TelegramClient.sticker(
    f: GetRecentStickers
): Stickers = exec(f) as Stickers

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
 * Returns stickers from the installed sticker sets that correspond to a given emoji
 * If the emoji is not empty, favorite and recently used stickers may also be returned
 *
 * @emoji - String representation of emoji
 *          If empty, returns all known installed stickers
 * @limit - Maximum number of stickers to be returned
 */
suspend fun TelegramClient.getStickers(
    emoji: String? = null,
    limit: Int = 0
): Stickers = sticker(
    GetStickers(
        emoji,
        limit
    )
)

/**
 * Returns stickers from the installed sticker sets that correspond to a given emoji
 * If the emoji is not empty, favorite and recently used stickers may also be returned
 */
suspend fun TelegramClient.sticker(
    f: GetStickers
): Stickers = exec(f) as Stickers

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
 * Searches for stickers from public sticker sets that correspond to a given emoji
 *
 * @emoji - String representation of emoji
 * @limit - Maximum number of stickers to be returned
 */
suspend fun TelegramClient.searchStickers(
    emoji: String? = null,
    limit: Int = 0
): Stickers = sticker(
    SearchStickers(
        emoji,
        limit
    )
)

/**
 * Searches for stickers from public sticker sets that correspond to a given emoji
 */
suspend fun TelegramClient.sticker(
    f: SearchStickers
): Stickers = exec(f) as Stickers

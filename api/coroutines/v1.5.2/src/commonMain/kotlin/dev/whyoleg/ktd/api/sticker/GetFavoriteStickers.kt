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
 * Returns favorite stickers
 */
suspend fun TelegramClient.getFavoriteStickers(): Stickers = sticker(
    GetFavoriteStickers()
)

/**
 * Returns favorite stickers
 */
suspend fun TelegramClient.sticker(
    f: GetFavoriteStickers
): Stickers = exec(f) as Stickers

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
 * Returns a list of trending sticker sets
 */
suspend fun TelegramClient.getTrendingStickerSets(): StickerSets = sticker(
    GetTrendingStickerSets()
)

/**
 * Returns a list of trending sticker sets
 */
suspend fun TelegramClient.sticker(
    f: GetTrendingStickerSets
): StickerSets = exec(f) as StickerSets

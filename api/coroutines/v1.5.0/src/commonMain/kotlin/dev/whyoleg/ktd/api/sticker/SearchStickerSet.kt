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
 * Searches for a sticker set by its name
 *
 * @name - Name of the sticker set
 */
suspend fun TelegramClient.searchStickerSet(
    name: String? = null
): StickerSet = sticker(
    SearchStickerSet(
        name
    )
)

/**
 * Searches for a sticker set by its name
 */
suspend fun TelegramClient.sticker(
    f: SearchStickerSet
): StickerSet = exec(f) as StickerSet

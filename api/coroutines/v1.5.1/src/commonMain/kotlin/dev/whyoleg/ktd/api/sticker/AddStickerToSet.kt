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
 * Adds a new sticker to a set
 * Returns the sticker set
 *
 * @userId - Sticker set owner
 * @name - Sticker set name
 * @sticker - Sticker to add to the set
 */
@BotsOnly
suspend fun TelegramClient.addStickerToSet(
    userId: Int = 0,
    name: String? = null,
    sticker: InputSticker? = null
): StickerSet = sticker(
    AddStickerToSet(
        userId,
        name,
        sticker
    )
)

/**
 * Adds a new sticker to a set
 * Returns the sticker set
 */
@BotsOnly
suspend fun TelegramClient.sticker(
    f: AddStickerToSet
): StickerSet = exec(f) as StickerSet

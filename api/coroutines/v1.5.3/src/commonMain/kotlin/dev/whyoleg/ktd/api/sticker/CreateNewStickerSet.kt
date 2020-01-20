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
 * Creates a new sticker set
 * Returns the newly created sticker set
 *
 * @userId - Sticker set owner
 * @title - Sticker set title
 * @name - Sticker set name
 *         Can contain only English letters, digits and underscores
 *         Must end with *"_by_<bot username>"* (*<bot_username>* is case insensitive)
 * @isMasks - True, if stickers are masks
 * @stickers - List of stickers to be added to the set
 */
@BotsOnly
suspend fun TelegramClient.createNewStickerSet(
    userId: Int = 0,
    title: String? = null,
    name: String? = null,
    isMasks: Boolean = false,
    stickers: Array<InputSticker> = emptyArray()
): StickerSet = sticker(
    CreateNewStickerSet(
        userId,
        title,
        name,
        isMasks,
        stickers
    )
)

/**
 * Creates a new sticker set
 * Returns the newly created sticker set
 */
@BotsOnly
suspend fun TelegramClient.sticker(
    f: CreateNewStickerSet
): StickerSet = exec(f) as StickerSet

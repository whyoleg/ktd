package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Creates a new sticker set
 * Returns the newly created sticker set
 *
 * @property userId Sticker set owner
 * @property title Sticker set title
 * @property name Sticker set name
 *                Can contain only English letters, digits and underscores
 *                Must end with *"_by_<bot username>"* (*<bot_username>* is case insensitive)
 * @property isMasks True, if stickers are masks
 * @property stickers List of stickers to be added to the set
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.createNewStickerSet(
    userId: Int = 0,
    title: String? = null,
    name: String? = null,
    isMasks: Boolean = false,
    stickers: List<TdInputSticker> = emptyList(),
    extra: TdExtra = TdExtra.EMPTY
): TdStickerSet = exec(TdCreateNewStickerSet(userId, title, name, isMasks, stickers, extra))

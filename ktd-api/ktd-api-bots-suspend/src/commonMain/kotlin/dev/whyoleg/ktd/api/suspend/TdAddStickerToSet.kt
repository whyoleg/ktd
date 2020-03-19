package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds a new sticker to a set
 * Returns the sticker set
 *
 * @property userId Sticker set owner
 * @property name Sticker set name
 * @property sticker Sticker to add to the set
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.addStickerToSet(
    userId: Int = 0,
    name: String? = null,
    sticker: TdInputSticker? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdStickerSet = exec(TdAddStickerToSet(userId, name, sticker, extra))

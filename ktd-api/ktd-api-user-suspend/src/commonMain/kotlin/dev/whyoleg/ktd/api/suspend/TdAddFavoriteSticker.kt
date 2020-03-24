package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds a new sticker to the list of favorite stickers
 * The new sticker is added to the top of the list
 * If the sticker was already in the list, it is removed from the list first
 * Only stickers belonging to a sticker set can be added to this list
 *
 * @property sticker Sticker file to add
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.addFavoriteSticker(sticker: TdInputFile? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdAddFavoriteSticker(sticker, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes a sticker from the list of favorite stickers
 *
 * @property sticker Sticker file to delete from the list
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.removeFavoriteSticker(sticker: TdInputFile? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdRemoveFavoriteSticker(sticker, extra))

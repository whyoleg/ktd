package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a sticker set by its identifier
 *
 * @property setId Identifier of the sticker set
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getStickerSet(setId: Long = 0L, extra: TdExtra = TdExtra.EMPTY):
        TdStickerSet = exec(TdGetStickerSet(setId, extra))

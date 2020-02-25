package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a list of sticker sets attached to a file
 * Currently only photos and videos can have attached sticker sets
 *
 * @property fileId File identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getAttachedStickerSets(fileId: Int = 0, extra: TdExtra = TdExtra.EMPTY):
        TdStickerSets = exec(TdGetAttachedStickerSets(fileId, extra))

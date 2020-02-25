package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a list of archived sticker sets
 *
 * @property isMasks Pass true to return mask stickers sets
 *                   Pass false to return ordinary sticker sets
 * @property offsetStickerSetId Identifier of the sticker set from which to return the result
 * @property limit The maximum number of sticker sets to return
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getArchivedStickerSets(
    isMasks: Boolean = false,
    offsetStickerSetId: Long = 0L,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdStickerSets = exec(TdGetArchivedStickerSets(isMasks, offsetStickerSetId, limit, extra))

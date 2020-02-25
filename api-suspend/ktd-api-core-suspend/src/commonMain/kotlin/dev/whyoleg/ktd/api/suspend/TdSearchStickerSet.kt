package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches for a sticker set by its name
 *
 * @property name Name of the sticker set
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchStickerSet(name: String? = null, extra: TdExtra = TdExtra.EMPTY):
        TdStickerSet = exec(TdSearchStickerSet(name, extra))

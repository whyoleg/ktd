package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a list of trending sticker sets
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getTrendingStickerSets(extra: TdExtra = TdExtra.EMPTY): TdStickerSets =
        exec(TdGetTrendingStickerSets(extra))

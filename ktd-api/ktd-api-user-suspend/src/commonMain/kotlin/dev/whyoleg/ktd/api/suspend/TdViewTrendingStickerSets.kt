package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Informs the server that some trending sticker sets have been viewed by the user
 *
 * @property stickerSetIds Identifiers of viewed trending sticker sets
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.viewTrendingStickerSets(stickerSetIds: LongArray = longArrayOf(),
        extra: TdExtra = TdExtra.EMPTY): TdOk = exec(TdViewTrendingStickerSets(stickerSetIds,
        extra))

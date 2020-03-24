package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the order of installed sticker sets
 *
 * @property isMasks Pass true to change the order of mask sticker sets
 *                   Pass false to change the order of ordinary sticker sets
 * @property stickerSetIds Identifiers of installed sticker sets in the new correct order
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.reorderInstalledStickerSets(
    isMasks: Boolean = false,
    stickerSetIds: LongArray = longArrayOf(),
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdReorderInstalledStickerSets(isMasks, stickerSetIds, extra))

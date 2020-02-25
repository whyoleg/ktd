package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes a sticker from the list of recently used stickers
 *
 * @property isAttached Pass true to remove the sticker from the list of stickers recently attached to photo or video files
 *                      Pass false to remove the sticker from the list of recently sent stickers
 * @property sticker Sticker file to delete
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.removeRecentSticker(
    isAttached: Boolean = false,
    sticker: TdInputFile? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdRemoveRecentSticker(isAttached, sticker, extra))

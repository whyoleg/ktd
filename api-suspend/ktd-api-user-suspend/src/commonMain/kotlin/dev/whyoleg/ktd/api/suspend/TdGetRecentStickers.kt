package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a list of recently used stickers
 *
 * @property isAttached Pass true to return stickers and masks that were recently attached to photos or video files
 *                      Pass false to return recently sent stickers
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getRecentStickers(isAttached: Boolean = false, extra: TdExtra =
        TdExtra.EMPTY): TdStickers = exec(TdGetRecentStickers(isAttached, extra))

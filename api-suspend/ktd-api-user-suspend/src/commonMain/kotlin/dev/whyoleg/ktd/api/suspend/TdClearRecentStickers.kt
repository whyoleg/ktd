package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Clears the list of recently used stickers
 *
 * @property isAttached Pass true to clear the list of stickers recently attached to photo or video files
 *                      Pass false to clear the list of recently sent stickers
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.clearRecentStickers(isAttached: Boolean = false, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdClearRecentStickers(isAttached, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a list of installed sticker sets
 *
 * @property isMasks Pass true to return mask sticker sets
 *                   Pass false to return ordinary sticker sets
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getInstalledStickerSets(isMasks: Boolean = false, extra: TdExtra =
        TdExtra.EMPTY): TdStickerSets = exec(TdGetInstalledStickerSets(isMasks, extra))

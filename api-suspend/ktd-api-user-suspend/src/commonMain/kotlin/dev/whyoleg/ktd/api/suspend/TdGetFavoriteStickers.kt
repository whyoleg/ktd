package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns favorite stickers
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getFavoriteStickers(extra: TdExtra = TdExtra.EMPTY): TdStickers =
        exec(TdGetFavoriteStickers(extra))

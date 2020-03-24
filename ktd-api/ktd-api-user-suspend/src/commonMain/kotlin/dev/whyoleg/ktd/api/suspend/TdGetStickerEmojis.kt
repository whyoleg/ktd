package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns emoji corresponding to a sticker
 * The list is only for informational purposes, because a sticker is always sent with a fixed emoji from the corresponding Sticker object
 *
 * @property sticker Sticker file identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getStickerEmojis(sticker: TdInputFile? = null, extra: TdExtra =
        TdExtra.EMPTY): TdEmojis = exec(TdGetStickerEmojis(sticker, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes a sticker from the set to which it belongs
 * The sticker set must have been created by the bot
 *
 * @property sticker Sticker
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.removeStickerFromSet(sticker: TdInputFile? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdRemoveStickerFromSet(sticker, extra))

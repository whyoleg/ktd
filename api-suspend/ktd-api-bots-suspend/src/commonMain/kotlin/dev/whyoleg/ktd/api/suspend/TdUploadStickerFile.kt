package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Uploads a PNG image with a sticker
 * Returns the uploaded file
 *
 * @property userId Sticker file owner
 * @property pngSticker PNG image with the sticker
 *                      Must be up to 512 kB in size and fit in 512x512 square
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.uploadStickerFile(
    userId: Int = 0,
    pngSticker: TdInputFile? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdFile = exec(TdUploadStickerFile(userId, pngSticker, extra))

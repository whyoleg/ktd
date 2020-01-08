@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.file

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Uploads a PNG image with a sticker
 * Returns the uploaded file
 *
 * @userId - Sticker file owner
 * @pngSticker - PNG image with the sticker
 *               Must be up to 512 kB in size and fit in 512x512 square
 */
@BotsOnly
suspend fun TelegramClient.uploadStickerFile(
    userId: Int = 0,
    pngSticker: InputFile? = null
): File = file(
    UploadStickerFile(
        userId,
        pngSticker
    )
)

/**
 * Uploads a PNG image with a sticker
 * Returns the uploaded file
 */
@BotsOnly
suspend fun TelegramClient.file(
    f: UploadStickerFile
): File = exec(f) as File

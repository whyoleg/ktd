package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Uploads a PNG image with a sticker
 * Returns the uploaded file
 *
 * @property userId Sticker file owner
 * @property pngSticker PNG image with the sticker
 *                      Must be up to 512 kB in size and fit in 512x512 square
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("uploadStickerFile")
data class TdUploadStickerFile(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("png_sticker")
    val pngSticker: TdInputFile? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdFile> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdUploadStickerFile {
        return copy(extra = extra.copy(id = id))
    }
}

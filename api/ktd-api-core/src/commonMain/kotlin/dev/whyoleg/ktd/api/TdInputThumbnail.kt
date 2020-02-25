package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A thumbnail to be sent along with a file
 * Should be in JPEG or WEBP format for stickers, and less than 200 kB in size
 *
 * @property thumbnail Thumbnail file to send
 *                     Sending thumbnails by file_id is currently not supported
 * @property width Thumbnail width, usually shouldn't exceed 320
 *                 Use 0 if unknown
 * @property height Thumbnail height, usually shouldn't exceed 320
 *                  Use 0 if unknown
 */
@Serializable
@SerialName("inputThumbnail")
data class TdInputThumbnail(
    @SerialName("thumbnail")
    val thumbnail: TdInputFile,
    @SerialName("width")
    val width: Int,
    @SerialName("height")
    val height: Int
) : TdObject

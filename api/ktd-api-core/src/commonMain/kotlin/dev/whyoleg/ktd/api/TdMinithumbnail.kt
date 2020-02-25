package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Thumbnail image of a very poor quality and low resolution
 *
 * @property width Thumbnail width, usually doesn't exceed 40
 * @property height Thumbnail height, usually doesn't exceed 40
 * @property data The thumbnail in JPEG format
 */
@Serializable
@SerialName("minithumbnail")
data class TdMinithumbnail(
    @SerialName("width")
    val width: Int,
    @SerialName("height")
    val height: Int,
    @SerialName("data")
    val data: ByteArray
) : TdObject

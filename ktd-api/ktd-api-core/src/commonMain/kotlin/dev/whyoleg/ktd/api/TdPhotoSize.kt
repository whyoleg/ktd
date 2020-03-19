package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Photo description
 *
 * @property type Thumbnail type (see https://core.telegram.org/constructor/photoSize)
 * @property photo Information about the photo file
 * @property width Photo width
 * @property height Photo height
 */
@Serializable
@SerialName("photoSize")
data class TdPhotoSize(
    @SerialName("type")
    val type: String,
    @SerialName("photo")
    val photo: TdFile,
    @SerialName("width")
    val width: Int,
    @SerialName("height")
    val height: Int
) : TdObject

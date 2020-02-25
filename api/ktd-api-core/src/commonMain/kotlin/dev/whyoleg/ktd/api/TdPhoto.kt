package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a photo
 *
 * @property hasStickers True, if stickers were added to the photo
 * @property minithumbnail Photo minithumbnail
 * @property sizes Available variants of the photo, in different sizes
 */
@Serializable
@SerialName("photo")
data class TdPhoto(
    @SerialName("has_stickers")
    val hasStickers: Boolean,
    @SerialName("minithumbnail")
    val minithumbnail: TdMinithumbnail?,
    @SerialName("sizes")
    val sizes: List<TdPhotoSize>
) : TdObject

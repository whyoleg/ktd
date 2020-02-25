package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes an animation file
 * The animation must be encoded in GIF or MPEG4 format
 *
 * @property duration Duration of the animation, in seconds
 *                    As defined by the sender
 * @property width Width of the animation
 * @property height Height of the animation
 * @property fileName Original name of the file
 *                    As defined by the sender
 * @property mimeType MIME type of the file, usually "image/gif" or "video/mp4"
 * @property minithumbnail Animation minithumbnail
 * @property thumbnail Animation thumbnail
 * @property animation File containing the animation
 */
@Serializable
@SerialName("animation")
data class TdAnimation(
    @SerialName("duration")
    val duration: Int,
    @SerialName("width")
    val width: Int,
    @SerialName("height")
    val height: Int,
    @SerialName("file_name")
    val fileName: String,
    @SerialName("mime_type")
    val mimeType: String,
    @SerialName("minithumbnail")
    val minithumbnail: TdMinithumbnail?,
    @SerialName("thumbnail")
    val thumbnail: TdPhotoSize?,
    @SerialName("animation")
    val animation: TdFile
) : TdObject

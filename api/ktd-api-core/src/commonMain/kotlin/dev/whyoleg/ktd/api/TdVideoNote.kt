package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a video note
 * The video must be equal in width and height, cropped to a circle, and stored in MPEG4 format
 *
 * @property duration Duration of the video, in seconds
 *                    As defined by the sender
 * @property length Video width and height
 *                  As defined by the sender
 * @property minithumbnail Video minithumbnail
 * @property thumbnail Video thumbnail
 *                     As defined by the sender
 * @property video File containing the video
 */
@Serializable
@SerialName("videoNote")
data class TdVideoNote(
    @SerialName("duration")
    val duration: Int,
    @SerialName("length")
    val length: Int,
    @SerialName("minithumbnail")
    val minithumbnail: TdMinithumbnail?,
    @SerialName("thumbnail")
    val thumbnail: TdPhotoSize?,
    @SerialName("video")
    val video: TdFile
) : TdObject

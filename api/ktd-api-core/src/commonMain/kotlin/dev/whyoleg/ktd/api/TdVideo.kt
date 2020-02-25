package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a video file
 *
 * @property duration Duration of the video, in seconds
 *                    As defined by the sender
 * @property width Video width
 *                 As defined by the sender
 * @property height Video height
 *                  As defined by the sender
 * @property fileName Original name of the file
 *                    As defined by the sender
 * @property mimeType MIME type of the file
 *                    As defined by the sender
 * @property hasStickers True, if stickers were added to the video
 * @property supportsStreaming True, if the video should be tried to be streamed
 * @property minithumbnail Video minithumbnail
 * @property thumbnail Video thumbnail
 *                     As defined by the sender
 * @property video File containing the video
 */
@Serializable
@SerialName("video")
data class TdVideo(
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
    @SerialName("has_stickers")
    val hasStickers: Boolean,
    @SerialName("supports_streaming")
    val supportsStreaming: Boolean,
    @SerialName("minithumbnail")
    val minithumbnail: TdMinithumbnail?,
    @SerialName("thumbnail")
    val thumbnail: TdPhotoSize?,
    @SerialName("video")
    val video: TdFile
) : TdObject

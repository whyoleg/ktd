package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes an audio file
 * Audio is usually in MP3 or M4A format
 *
 * @property duration Duration of the audio, in seconds
 *                    As defined by the sender
 * @property title Title of the audio
 *                 As defined by the sender
 * @property performer Performer of the audio
 *                     As defined by the sender
 * @property fileName Original name of the file
 *                    As defined by the sender
 * @property mimeType The MIME type of the file
 *                    As defined by the sender
 * @property albumCoverMinithumbnail The minithumbnail of the album cover
 * @property albumCoverThumbnail The thumbnail of the album cover
 *                               As defined by the sender
 *                               The full size thumbnail should be extracted from the downloaded file
 * @property audio File containing the audio
 */
@Serializable
@SerialName("audio")
data class TdAudio(
    @SerialName("duration")
    val duration: Int,
    @SerialName("title")
    val title: String,
    @SerialName("performer")
    val performer: String,
    @SerialName("file_name")
    val fileName: String,
    @SerialName("mime_type")
    val mimeType: String,
    @SerialName("album_cover_minithumbnail")
    val albumCoverMinithumbnail: TdMinithumbnail?,
    @SerialName("album_cover_thumbnail")
    val albumCoverThumbnail: TdPhotoSize?,
    @SerialName("audio")
    val audio: TdFile
) : TdObject

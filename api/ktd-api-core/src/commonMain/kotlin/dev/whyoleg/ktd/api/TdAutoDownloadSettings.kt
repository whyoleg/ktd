package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains auto-download settings
 *
 * @property isAutoDownloadEnabled True, if the auto-download is enabled
 * @property maxPhotoFileSize The maximum size of a photo file to be auto-downloaded
 * @property maxVideoFileSize The maximum size of a video file to be auto-downloaded
 * @property maxOtherFileSize The maximum size of other file types to be auto-downloaded
 * @property videoUploadBitrate The maximum suggested bitrate for uploaded videos
 * @property preloadLargeVideos True, if the beginning of videos needs to be preloaded for instant playback
 * @property preloadNextAudio True, if the next audio track needs to be preloaded while the user is listening to an audio file
 * @property useLessDataForCalls True, if "use less data for calls" option needs to be enabled
 */
@Serializable
@SerialName("autoDownloadSettings")
data class TdAutoDownloadSettings(
    @SerialName("is_auto_download_enabled")
    val isAutoDownloadEnabled: Boolean,
    @SerialName("max_photo_file_size")
    val maxPhotoFileSize: Int,
    @SerialName("max_video_file_size")
    val maxVideoFileSize: Int,
    @SerialName("max_other_file_size")
    val maxOtherFileSize: Int,
    @SerialName("video_upload_bitrate")
    val videoUploadBitrate: Int,
    @SerialName("preload_large_videos")
    val preloadLargeVideos: Boolean,
    @SerialName("preload_next_audio")
    val preloadNextAudio: Boolean,
    @SerialName("use_less_data_for_calls")
    val useLessDataForCalls: Boolean
) : TdObject

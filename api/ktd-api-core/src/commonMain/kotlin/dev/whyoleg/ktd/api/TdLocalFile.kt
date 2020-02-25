package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a local file
 *
 * @property path Local path to the locally available file part
 * @property canBeDownloaded True, if it is possible to try to download or generate the file
 * @property canBeDeleted True, if the file can be deleted
 * @property isDownloadingActive True, if the file is currently being downloaded (or a local copy is being generated by some other means)
 * @property isDownloadingCompleted True, if the local copy is fully available
 * @property downloadOffset Download will be started from this offset
 *                          Downloaded_prefix_size is calculated from this offset
 * @property downloadedPrefixSize If is_downloading_completed is false, then only some prefix of the file starting from download_offset is ready to be read
 *                                Downloaded_prefix_size is the size of that prefix
 * @property downloadedSize Total downloaded file bytes
 *                          Should be used only for calculating download progress
 *                          The actual file size may be bigger, and some parts of it may contain garbage
 */
@Serializable
@SerialName("localFile")
data class TdLocalFile(
    @SerialName("path")
    val path: String?,
    @SerialName("can_be_downloaded")
    val canBeDownloaded: Boolean,
    @SerialName("can_be_deleted")
    val canBeDeleted: Boolean,
    @SerialName("is_downloading_active")
    val isDownloadingActive: Boolean,
    @SerialName("is_downloading_completed")
    val isDownloadingCompleted: Boolean,
    @SerialName("download_offset")
    val downloadOffset: Int,
    @SerialName("downloaded_prefix_size")
    val downloadedPrefixSize: Int,
    @SerialName("downloaded_size")
    val downloadedSize: Int
) : TdObject

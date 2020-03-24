package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains the storage usage statistics for a specific file type
 *
 * @property fileType File type
 * @property size Total size of the files
 * @property count Total number of files
 */
@Serializable
@SerialName("storageStatisticsByFileType")
data class TdStorageStatisticsByFileType(
    @SerialName("file_type")
    val fileType: TdFileType,
    @SerialName("size")
    val size: Long,
    @SerialName("count")
    val count: Int
) : TdObject

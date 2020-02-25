package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains the exact storage usage statistics split by chats and file type
 *
 * @property size Total size of files
 * @property count Total number of files
 * @property byChat Statistics split by chats
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("storageStatistics")
data class TdStorageStatistics(
    @SerialName("size")
    val size: Long,
    @SerialName("count")
    val count: Int,
    @SerialName("by_chat")
    val byChat: List<TdStorageStatisticsByChat>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

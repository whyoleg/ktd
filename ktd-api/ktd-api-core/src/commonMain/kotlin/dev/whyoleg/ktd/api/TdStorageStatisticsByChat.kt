package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains the storage usage statistics for a specific chat
 *
 * @property chatId Chat identifier
 *                  0 if none
 * @property size Total size of the files in the chat
 * @property count Total number of files in the chat
 * @property byFileType Statistics split by file types
 */
@Serializable
@SerialName("storageStatisticsByChat")
data class TdStorageStatisticsByChat(
    @SerialName("chat_id")
    val chatId: Long,
    @SerialName("size")
    val size: Long,
    @SerialName("count")
    val count: Int,
    @SerialName("by_file_type")
    val byFileType: List<TdStorageStatisticsByFileType>
) : TdObject

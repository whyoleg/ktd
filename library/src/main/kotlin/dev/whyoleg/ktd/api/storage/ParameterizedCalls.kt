@file:Suppress("unused")

package dev.whyoleg.ktd.api.storage

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns storage usage statistics. Can be called before authorization
 *
 * @chatLimit - Maximum number of chats with the largest storage usage for which separate statistics should be returned. All other chats will be grouped in entries with chat_id == 0. If the chat info database is not used, the chatLimit is ignored and is always set to 0
 */
suspend fun TelegramClient.getStorageStatistics(
    chatLimit: Int
): StorageStatistics = storage(
    GetStorageStatistics(
        chatLimit
    )
)

/**
 * Quickly returns approximate storage usage statistics. Can be called before authorization
 */
suspend fun TelegramClient.getStorageStatisticsFast(): StorageStatisticsFast = storage(
    GetStorageStatisticsFast()
)

/**
 * Optimizes storage usage, i.e. deletes some files and returns new storage usage statistics. Secret thumbnails can't be deleted
 *
 * @size - Limit on the total size of files after deletion. Pass -1 to use the default limit
 * @ttl - Limit on the time that has passed since the last time a file was accessed (or creation time for some filesystems). Pass -1 to use the default limit
 * @count - Limit on the total count of files after deletion. Pass -1 to use the default limit
 * @immunityDelay - The amount of time after the creation of a file during which it can't be deleted, in seconds. Pass -1 to use the default value
 * @fileTypes - If not empty, only files with the given type(s) are considered. By default, all types except thumbnails, profile photos, stickers and wallpapers are deleted
 * @chatIds - If not empty, only files from the given chats are considered. Use 0 as chat identifier to delete files not belonging to any chat (e.g., profile photos)
 * @excludeChatIds - If not empty, files from the given chats are excluded. Use 0 as chat identifier to exclude all files not belonging to any chat (e.g., profile photos)
 * @chatLimit - Same as in getStorageStatistics. Affects only returned statistics
 */
suspend fun TelegramClient.optimizeStorage(
    size: Long,
    ttl: Int,
    count: Int,
    immunityDelay: Int,
    fileTypes: Array<FileType>,
    chatIds: LongArray,
    excludeChatIds: LongArray,
    chatLimit: Int
): StorageStatistics = storage(
    OptimizeStorage(
        size,
        ttl,
        count,
        immunityDelay,
        fileTypes,
        chatIds,
        excludeChatIds,
        chatLimit
    )
)

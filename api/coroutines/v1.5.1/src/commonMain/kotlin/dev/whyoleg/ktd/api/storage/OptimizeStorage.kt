@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.storage

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Optimizes storage usage, i.e
 * Deletes some files and returns new storage usage statistics
 * Secret thumbnails can't be deleted
 *
 * @size - Limit on the total size of files after deletion
 *         Pass -1 to use the default limit
 * @ttl - Limit on the time that has passed since the last time a file was accessed (or creation time for some filesystems)
 *        Pass -1 to use the default limit
 * @count - Limit on the total count of files after deletion
 *          Pass -1 to use the default limit
 * @immunityDelay - The amount of time after the creation of a file during which it can't be deleted, in seconds
 *                  Pass -1 to use the default value
 * @fileTypes - If not empty, only files with the given type(s) are considered
 *              By default, all types except thumbnails, profile photos, stickers and wallpapers are deleted
 * @chatIds - If not empty, only files from the given chats are considered
 *            Use 0 as chat identifier to delete files not belonging to any chat (e.g., profile photos)
 * @excludeChatIds - If not empty, files from the given chats are excluded
 *                   Use 0 as chat identifier to exclude all files not belonging to any chat (e.g., profile photos)
 * @chatLimit - Same as in getStorageStatistics
 *              Affects only returned statistics
 */
suspend fun TelegramClient.optimizeStorage(
    size: Long = 0L,
    ttl: Int = 0,
    count: Int = 0,
    immunityDelay: Int = 0,
    fileTypes: Array<FileType> = emptyArray(),
    chatIds: LongArray = longArrayOf(),
    excludeChatIds: LongArray = longArrayOf(),
    chatLimit: Int = 0
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

/**
 * Optimizes storage usage, i.e
 * Deletes some files and returns new storage usage statistics
 * Secret thumbnails can't be deleted
 */
suspend fun TelegramClient.storage(
    f: OptimizeStorage
): StorageStatistics = exec(f) as StorageStatistics

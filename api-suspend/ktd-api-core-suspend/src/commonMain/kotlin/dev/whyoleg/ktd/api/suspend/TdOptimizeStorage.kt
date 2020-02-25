package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Optimizes storage usage, i.e
 * Deletes some files and returns new storage usage statistics
 * Secret thumbnails can't be deleted
 *
 * @property size Limit on the total size of files after deletion
 *                Pass -1 to use the default limit
 * @property ttl Limit on the time that has passed since the last time a file was accessed (or creation time for some filesystems)
 *               Pass -1 to use the default limit
 * @property count Limit on the total count of files after deletion
 *                 Pass -1 to use the default limit
 * @property immunityDelay The amount of time after the creation of a file during which it can't be deleted, in seconds
 *                         Pass -1 to use the default value
 * @property fileTypes If not empty, only files with the given type(s) are considered
 *                     By default, all types except thumbnails, profile photos, stickers and wallpapers are deleted
 * @property chatIds If not empty, only files from the given chats are considered
 *                   Use 0 as chat identifier to delete files not belonging to any chat (e.g., profile photos)
 * @property excludeChatIds If not empty, files from the given chats are excluded
 *                          Use 0 as chat identifier to exclude all files not belonging to any chat (e.g., profile photos)
 * @property chatLimit Same as in getStorageStatistics
 *                     Affects only returned statistics
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.optimizeStorage(
    size: Long = 0L,
    ttl: Int = 0,
    count: Int = 0,
    immunityDelay: Int = 0,
    fileTypes: List<TdFileType> = emptyList(),
    chatIds: LongArray = longArrayOf(),
    excludeChatIds: LongArray = longArrayOf(),
    chatLimit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdStorageStatistics = exec(TdOptimizeStorage(size, ttl, count, immunityDelay, fileTypes, chatIds,
        excludeChatIds, chatLimit, extra))

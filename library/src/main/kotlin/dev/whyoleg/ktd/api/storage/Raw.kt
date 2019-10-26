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
 * Returns storage usage statistics
 * Can be called before authorization
 */
suspend fun TelegramClient.storage(
    f: GetStorageStatistics
): StorageStatistics = execRaw(f) as StorageStatistics

/**
 * Quickly returns approximate storage usage statistics
 * Can be called before authorization
 */
suspend fun TelegramClient.storage(
    f: GetStorageStatisticsFast
): StorageStatisticsFast = execRaw(f) as StorageStatisticsFast

/**
 * Optimizes storage usage, i.e
 * Deletes some files and returns new storage usage statistics
 * Secret thumbnails can't be deleted
 */
suspend fun TelegramClient.storage(
    f: OptimizeStorage
): StorageStatistics = execRaw(f) as StorageStatistics

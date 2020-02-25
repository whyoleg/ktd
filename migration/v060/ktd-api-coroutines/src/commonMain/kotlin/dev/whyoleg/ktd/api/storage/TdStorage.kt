@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.storage

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.storage(f: TdGetStorageStatistics): TdStorageStatistics = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getStorageStatistics(chatLimit)",
            "dev.whyoleg.ktd.api.suspend.getStorageStatistics"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getStorageStatistics(chatLimit: Int = 0): TdStorageStatistics =
        exec(TdGetStorageStatistics(chatLimit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.storage(f: TdGetStorageStatisticsFast): TdStorageStatisticsFast = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getStorageStatisticsFast()",
            "dev.whyoleg.ktd.api.suspend.getStorageStatisticsFast"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getStorageStatisticsFast(): TdStorageStatisticsFast =
        exec(TdGetStorageStatisticsFast())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.storage(f: TdOptimizeStorage): TdStorageStatistics = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("optimizeStorage(size, ttl, count, immunityDelay, fileTypes, chatIds, excludeChatIds, chatLimit)",
            "dev.whyoleg.ktd.api.suspend.optimizeStorage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.optimizeStorage(
    size: Long = 0L,
    ttl: Int = 0,
    count: Int = 0,
    immunityDelay: Int = 0,
    fileTypes: List<TdFileType> = emptyList(),
    chatIds: LongArray = longArrayOf(),
    excludeChatIds: LongArray = longArrayOf(),
    chatLimit: Int = 0
): TdStorageStatistics = exec(TdOptimizeStorage(size, ttl, count, immunityDelay, fileTypes, chatIds,
        excludeChatIds, chatLimit))

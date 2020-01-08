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
 * Quickly returns approximate storage usage statistics
 * Can be called before authorization
 */
suspend fun TelegramClient.getStorageStatisticsFast(): StorageStatisticsFast = storage(
    GetStorageStatisticsFast()
)

/**
 * Quickly returns approximate storage usage statistics
 * Can be called before authorization
 */
suspend fun TelegramClient.storage(
    f: GetStorageStatisticsFast
): StorageStatisticsFast = exec(f) as StorageStatisticsFast

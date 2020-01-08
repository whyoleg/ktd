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
 *
 * @chatLimit - Maximum number of chats with the largest storage usage for which separate statistics should be returned
 *              All other chats will be grouped in entries with chat_id == 0
 *              If the chat info database is not used, the chat_limit is ignored and is always set to 0
 */
suspend fun TelegramClient.getStorageStatistics(
    chatLimit: Int = 0
): StorageStatistics = storage(
    GetStorageStatistics(
        chatLimit
    )
)

/**
 * Returns storage usage statistics
 * Can be called before authorization
 */
suspend fun TelegramClient.storage(
    f: GetStorageStatistics
): StorageStatistics = exec(f) as StorageStatistics

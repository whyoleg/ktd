@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.database

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns database statistics
 */
suspend fun TelegramClient.getDatabaseStatistics(): DatabaseStatistics = database(
    GetDatabaseStatistics()
)

/**
 * Returns database statistics
 */
suspend fun TelegramClient.database(
    f: GetDatabaseStatistics
): DatabaseStatistics = exec(f) as DatabaseStatistics

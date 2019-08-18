@file:Suppress("unused")

package dev.whyoleg.ktd.api.database

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes the database encryption key. Usually the encryption key is never changed and is stored in some OS keychain
 */
suspend fun TelegramClient.database(
    f: SetDatabaseEncryptionKey
): Ok = execRaw(f) as Ok

/**
 * Returns database statistics
 */
suspend fun TelegramClient.database(
    f: GetDatabaseStatistics
): DatabaseStatistics = execRaw(f) as DatabaseStatistics

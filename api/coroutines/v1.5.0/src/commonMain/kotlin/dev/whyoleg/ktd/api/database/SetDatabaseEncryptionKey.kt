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
 * Changes the database encryption key
 * Usually the encryption key is never changed and is stored in some OS keychain
 *
 * @newEncryptionKey - New encryption key
 */
suspend fun TelegramClient.setDatabaseEncryptionKey(
    newEncryptionKey: ByteArray = byteArrayOf()
): Ok = database(
    SetDatabaseEncryptionKey(
        newEncryptionKey
    )
)

/**
 * Changes the database encryption key
 * Usually the encryption key is never changed and is stored in some OS keychain
 */
suspend fun TelegramClient.database(
    f: SetDatabaseEncryptionKey
): Ok = exec(f) as Ok

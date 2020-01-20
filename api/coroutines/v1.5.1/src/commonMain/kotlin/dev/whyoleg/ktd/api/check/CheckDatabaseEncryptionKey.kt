@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.check

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Checks the database encryption key for correctness
 * Works only when the current authorization state is authorizationStateWaitEncryptionKey
 *
 * @encryptionKey - Encryption key to check or set up
 */
suspend fun TelegramClient.checkDatabaseEncryptionKey(
    encryptionKey: ByteArray = byteArrayOf()
): Ok = check(
    CheckDatabaseEncryptionKey(
        encryptionKey
    )
)

/**
 * Checks the database encryption key for correctness
 * Works only when the current authorization state is authorizationStateWaitEncryptionKey
 */
suspend fun TelegramClient.check(
    f: CheckDatabaseEncryptionKey
): Ok = exec(f) as Ok

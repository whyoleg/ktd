package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Checks the database encryption key for correctness
 * Works only when the current authorization state is authorizationStateWaitEncryptionKey
 *
 * @property encryptionKey Encryption key to check or set up
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.checkDatabaseEncryptionKey(encryptionKey: ByteArray = byteArrayOf(),
        extra: TdExtra = TdExtra.EMPTY): TdOk = exec(TdCheckDatabaseEncryptionKey(encryptionKey,
        extra))

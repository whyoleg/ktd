package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the database encryption key
 * Usually the encryption key is never changed and is stored in some OS keychain
 *
 * @property newEncryptionKey New encryption key
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setDatabaseEncryptionKey(newEncryptionKey: ByteArray = byteArrayOf(),
        extra: TdExtra = TdExtra.EMPTY): TdOk = exec(TdSetDatabaseEncryptionKey(newEncryptionKey,
        extra))

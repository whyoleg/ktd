package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the database encryption key
 * Usually the encryption key is never changed and is stored in some OS keychain
 *
 * @property newEncryptionKey New encryption key
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setDatabaseEncryptionKey")
data class TdSetDatabaseEncryptionKey(
    @SerialName("new_encryption_key")
    val newEncryptionKey: ByteArray = byteArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetDatabaseEncryptionKey {
        return copy(extra = extra.copy(id = id))
    }
}

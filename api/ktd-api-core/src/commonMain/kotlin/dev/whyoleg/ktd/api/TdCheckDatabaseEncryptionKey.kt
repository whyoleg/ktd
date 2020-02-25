package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Checks the database encryption key for correctness
 * Works only when the current authorization state is authorizationStateWaitEncryptionKey
 *
 * @property encryptionKey Encryption key to check or set up
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("checkDatabaseEncryptionKey")
data class TdCheckDatabaseEncryptionKey(
    @SerialName("encryption_key")
    val encryptionKey: ByteArray = byteArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCheckDatabaseEncryptionKey {
        return copy(extra = extra.copy(id = id))
    }
}

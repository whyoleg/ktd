package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains encrypted Telegram Passport data credentials
 *
 * @property data The encrypted credentials
 * @property hash The decrypted data hash
 * @property secret Secret for data decryption, encrypted with the service's public key
 */
@Serializable
@SerialName("encryptedCredentials")
data class TdEncryptedCredentials(
    @SerialName("data")
    val data: ByteArray,
    @SerialName("hash")
    val hash: ByteArray,
    @SerialName("secret")
    val secret: ByteArray
) : TdObject

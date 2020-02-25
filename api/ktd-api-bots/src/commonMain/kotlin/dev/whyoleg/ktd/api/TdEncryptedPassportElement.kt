package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about an encrypted Telegram Passport element
 *
 * @property type Type of Telegram Passport element
 * @property data Encrypted JSON-encoded data about the user
 * @property frontSide The front side of an identity document
 * @property reverseSide The reverse side of an identity document
 * @property selfie Selfie with the document
 * @property translation List of files containing a certified English translation of the document
 * @property files List of attached files
 * @property value Unencrypted data, phone number or email address
 * @property hash Hash of the entire element
 */
@Serializable
@SerialName("encryptedPassportElement")
data class TdEncryptedPassportElement(
    @SerialName("type")
    val type: TdPassportElementType,
    @SerialName("data")
    val data: ByteArray,
    @SerialName("front_side")
    val frontSide: TdDatedFile,
    @SerialName("reverse_side")
    val reverseSide: TdDatedFile?,
    @SerialName("selfie")
    val selfie: TdDatedFile?,
    @SerialName("translation")
    val translation: List<TdDatedFile>,
    @SerialName("files")
    val files: List<TdDatedFile>,
    @SerialName("value")
    val value: String,
    @SerialName("hash")
    val hash: String
) : TdObject

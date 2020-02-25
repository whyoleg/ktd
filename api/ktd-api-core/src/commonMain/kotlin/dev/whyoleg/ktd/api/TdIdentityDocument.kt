package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * An identity document
 *
 * @property number Document number
 * @property expiryDate Document expiry date
 * @property frontSide Front side of the document
 * @property reverseSide Reverse side of the document
 *                       Only for driver license and identity card
 * @property selfie Selfie with the document
 * @property translation List of files containing a certified English translation of the document
 */
@Serializable
@SerialName("identityDocument")
data class TdIdentityDocument(
    @SerialName("number")
    val number: String,
    @SerialName("expiry_date")
    val expiryDate: TdDate?,
    @SerialName("front_side")
    val frontSide: TdDatedFile,
    @SerialName("reverse_side")
    val reverseSide: TdDatedFile,
    @SerialName("selfie")
    val selfie: TdDatedFile?,
    @SerialName("translation")
    val translation: List<TdDatedFile>
) : TdObject

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * An identity document to be saved to Telegram Passport
 *
 * @property number Document number
 * @property expiryDate Document expiry date, if available
 * @property frontSide Front side of the document
 * @property reverseSide Reverse side of the document
 *                       Only for driver license and identity card
 * @property selfie Selfie with the document, if available
 * @property translation List of files containing a certified English translation of the document
 */
@Serializable
@SerialName("inputIdentityDocument")
data class TdInputIdentityDocument(
    @SerialName("number")
    val number: String,
    @SerialName("expiry_date")
    val expiryDate: TdDate,
    @SerialName("front_side")
    val frontSide: TdInputFile,
    @SerialName("reverse_side")
    val reverseSide: TdInputFile,
    @SerialName("selfie")
    val selfie: TdInputFile,
    @SerialName("translation")
    val translation: List<TdInputFile>
) : TdObject

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains the description of an error in a Telegram Passport element
 *
 * @property type Type of the Telegram Passport element which has the error
 * @property message Error message
 * @property source Error source
 */
@Serializable
@SerialName("passportElementError")
data class TdPassportElementError(
    @SerialName("type")
    val type: TdPassportElementType,
    @SerialName("message")
    val message: String,
    @SerialName("source")
    val source: TdPassportElementErrorSource
) : TdObject

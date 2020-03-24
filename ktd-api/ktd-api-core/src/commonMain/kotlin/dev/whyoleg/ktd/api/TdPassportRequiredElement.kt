package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a description of the required Telegram Passport element that was requested by a service
 *
 * @property suitableElements List of Telegram Passport elements any of which is enough to provide
 */
@Serializable
@SerialName("passportRequiredElement")
data class TdPassportRequiredElement(
    @SerialName("suitable_elements")
    val suitableElements: List<TdPassportSuitableElement>
) : TdObject

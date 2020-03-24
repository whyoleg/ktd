package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a Telegram Passport element that was requested by a service
 *
 * @property type Type of the element
 * @property isSelfieRequired True, if a selfie is required with the identity document
 * @property isTranslationRequired True, if a certified English translation is required with the document
 * @property isNativeNameRequired True, if personal details must include the user's name in the language of their country of residence
 */
@Serializable
@SerialName("passportSuitableElement")
data class TdPassportSuitableElement(
    @SerialName("type")
    val type: TdPassportElementType,
    @SerialName("is_selfie_required")
    val isSelfieRequired: Boolean,
    @SerialName("is_translation_required")
    val isTranslationRequired: Boolean,
    @SerialName("is_native_name_required")
    val isNativeNameRequired: Boolean
) : TdObject

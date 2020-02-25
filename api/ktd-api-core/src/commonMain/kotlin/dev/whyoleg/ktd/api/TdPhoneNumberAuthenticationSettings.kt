package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains settings for the authentication of the user's phone number
 *
 * @property allowFlashCall Pass true if the authentication code may be sent via flash call to the specified phone number
 * @property isCurrentPhoneNumber Pass true if the authenticated phone number is used on the current device
 * @property allowSmsRetrieverApi For official applications only
 *                                True, if the app can use Android SMS Retriever API (requires Google Play Services >= 10.2) to automatically receive the authentication code from the SMS
 *                                See https://developers.google.com/identity/sms-retriever/ for more details
 */
@Serializable
@SerialName("phoneNumberAuthenticationSettings")
data class TdPhoneNumberAuthenticationSettings(
    @SerialName("allow_flash_call")
    val allowFlashCall: Boolean,
    @SerialName("is_current_phone_number")
    val isCurrentPhoneNumber: Boolean,
    @SerialName("allow_sms_retriever_api")
    val allowSmsRetrieverApi: Boolean
) : TdObject

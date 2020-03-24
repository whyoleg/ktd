package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Provides information about the method by which an authentication code is delivered to the user
 */
@Serializable
sealed class TdAuthenticationCodeType : TdObject {
    /**
     * An authentication code is delivered via a private Telegram message, which can be viewed in another client
     *
     * @property length Length of the code
     */
    @Serializable
    @SerialName("authenticationCodeTypeTelegramMessage")
    data class TelegramMessage(
        @SerialName("length")
        val length: Int
    ) : TdAuthenticationCodeType()

    /**
     * An authentication code is delivered via an SMS message to the specified phone number
     *
     * @property length Length of the code
     */
    @Serializable
    @SerialName("authenticationCodeTypeSms")
    data class Sms(
        @SerialName("length")
        val length: Int
    ) : TdAuthenticationCodeType()

    /**
     * An authentication code is delivered via a phone call to the specified phone number
     *
     * @property length Length of the code
     */
    @Serializable
    @SerialName("authenticationCodeTypeCall")
    data class Call(
        @SerialName("length")
        val length: Int
    ) : TdAuthenticationCodeType()

    /**
     * An authentication code is delivered by an immediately cancelled call to the specified phone number
     * The number from which the call was made is the code
     *
     * @property pattern Pattern of the phone number from which the call will be made
     */
    @Serializable
    @SerialName("authenticationCodeTypeFlashCall")
    data class FlashCall(
        @SerialName("pattern")
        val pattern: String
    ) : TdAuthenticationCodeType()
}

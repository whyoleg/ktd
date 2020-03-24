package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends a code to verify a phone number to be added to a user's Telegram Passport
 *
 * @property phoneNumber The phone number of the user, in international format
 * @property settings Settings for the authentication of the user's phone number
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendPhoneNumberVerificationCode")
data class TdSendPhoneNumberVerificationCode(
    @SerialName("phone_number")
    val phoneNumber: String? = null,
    @SerialName("settings")
    val settings: TdPhoneNumberAuthenticationSettings? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdAuthenticationCodeInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendPhoneNumberVerificationCode {
        return copy(extra = extra.copy(id = id))
    }
}

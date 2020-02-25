package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sets the phone number of the user and sends an authentication code to the user
 * Works only when the current authorization state is authorizationStateWaitPhoneNumber, or if there is no pending authentication query and the current authorization state is authorizationStateWaitCode, authorizationStateWaitRegistration, or authorizationStateWaitPassword
 *
 * @property phoneNumber The phone number of the user, in international format
 * @property settings Settings for the authentication of the user's phone number
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setAuthenticationPhoneNumber")
data class TdSetAuthenticationPhoneNumber(
    @SerialName("phone_number")
    val phoneNumber: String? = null,
    @SerialName("settings")
    val settings: TdPhoneNumberAuthenticationSettings? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetAuthenticationPhoneNumber {
        return copy(extra = extra.copy(id = id))
    }
}

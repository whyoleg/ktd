package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the phone number of the user and sends an authentication code to the user's new phone number
 * On success, returns information about the sent code
 *
 * @property phoneNumber The new phone number of the user in international format
 * @property settings Settings for the authentication of the user's phone number
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("changePhoneNumber")
data class TdChangePhoneNumber(
    @SerialName("phone_number")
    val phoneNumber: String? = null,
    @SerialName("settings")
    val settings: TdPhoneNumberAuthenticationSettings? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdAuthenticationCodeInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdChangePhoneNumber {
        return copy(extra = extra.copy(id = id))
    }
}

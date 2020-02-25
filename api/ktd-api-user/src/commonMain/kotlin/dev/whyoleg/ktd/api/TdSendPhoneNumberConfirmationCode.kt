package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends phone number confirmation code
 * Should be called when user presses "https://t.me/confirmphone?phone=*******&hash=**********" or "tg://confirmphone?phone=*******&hash=**********" link
 *
 * @property hash Value of the "hash" parameter from the link
 * @property phoneNumber Value of the "phone" parameter from the link
 * @property settings Settings for the authentication of the user's phone number
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendPhoneNumberConfirmationCode")
data class TdSendPhoneNumberConfirmationCode(
    @SerialName("hash")
    val hash: String? = null,
    @SerialName("phone_number")
    val phoneNumber: String? = null,
    @SerialName("settings")
    val settings: TdPhoneNumberAuthenticationSettings? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdAuthenticationCodeInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendPhoneNumberConfirmationCode {
        return copy(extra = extra.copy(id = id))
    }
}

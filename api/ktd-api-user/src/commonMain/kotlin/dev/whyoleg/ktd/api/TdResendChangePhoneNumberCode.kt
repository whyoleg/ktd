package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Re-sends the authentication code sent to confirm a new phone number for the user
 * Works only if the previously received authenticationCodeInfo next_code_type was not null
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("resendChangePhoneNumberCode")
data class TdResendChangePhoneNumberCode(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdAuthenticationCodeInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdResendChangePhoneNumberCode {
        return copy(extra = extra.copy(id = id))
    }
}

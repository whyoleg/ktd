package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Re-sends the code to verify a phone number to be added to a user's Telegram Passport
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("resendPhoneNumberVerificationCode")
data class TdResendPhoneNumberVerificationCode(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdAuthenticationCodeInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdResendPhoneNumberVerificationCode {
        return copy(extra = extra.copy(id = id))
    }
}

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Re-sends the code to verify an email address to be added to a user's Telegram Passport
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("resendEmailAddressVerificationCode")
data class TdResendEmailAddressVerificationCode(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdEmailAddressAuthenticationCodeInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdResendEmailAddressVerificationCode {
        return copy(extra = extra.copy(id = id))
    }
}

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends a code to verify an email address to be added to a user's Telegram Passport
 *
 * @property emailAddress Email address
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendEmailAddressVerificationCode")
data class TdSendEmailAddressVerificationCode(
    @SerialName("email_address")
    val emailAddress: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdEmailAddressAuthenticationCodeInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendEmailAddressVerificationCode {
        return copy(extra = extra.copy(id = id))
    }
}

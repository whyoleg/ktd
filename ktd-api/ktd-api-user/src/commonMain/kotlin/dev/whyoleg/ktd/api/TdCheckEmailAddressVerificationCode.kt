package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Checks the email address verification code for Telegram Passport
 *
 * @property code Verification code
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("checkEmailAddressVerificationCode")
data class TdCheckEmailAddressVerificationCode(
    @SerialName("code")
    val code: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCheckEmailAddressVerificationCode {
        return copy(extra = extra.copy(id = id))
    }
}

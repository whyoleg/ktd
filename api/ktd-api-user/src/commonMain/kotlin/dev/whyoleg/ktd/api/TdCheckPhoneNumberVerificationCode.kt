package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Checks the phone number verification code for Telegram Passport
 *
 * @property code Verification code
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("checkPhoneNumberVerificationCode")
data class TdCheckPhoneNumberVerificationCode(
    @SerialName("code")
    val code: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCheckPhoneNumberVerificationCode {
        return copy(extra = extra.copy(id = id))
    }
}

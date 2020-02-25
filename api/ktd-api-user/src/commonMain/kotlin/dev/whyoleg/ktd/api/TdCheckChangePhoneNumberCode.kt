package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Checks the authentication code sent to confirm a new phone number of the user
 *
 * @property code Verification code received by SMS, phone call or flash call
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("checkChangePhoneNumberCode")
data class TdCheckChangePhoneNumberCode(
    @SerialName("code")
    val code: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCheckChangePhoneNumberCode {
        return copy(extra = extra.copy(id = id))
    }
}

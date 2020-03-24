package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Checks phone number confirmation code
 *
 * @property code The phone number confirmation code
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("checkPhoneNumberConfirmationCode")
data class TdCheckPhoneNumberConfirmationCode(
    @SerialName("code")
    val code: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCheckPhoneNumberConfirmationCode {
        return copy(extra = extra.copy(id = id))
    }
}

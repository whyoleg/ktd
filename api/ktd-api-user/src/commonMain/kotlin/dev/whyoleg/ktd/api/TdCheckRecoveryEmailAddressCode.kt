package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Checks the 2-step verification recovery email address verification code
 *
 * @property code Verification code
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("checkRecoveryEmailAddressCode")
data class TdCheckRecoveryEmailAddressCode(
    @SerialName("code")
    val code: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPasswordState> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCheckRecoveryEmailAddressCode {
        return copy(extra = extra.copy(id = id))
    }
}

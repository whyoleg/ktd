package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Resends the 2-step verification recovery email address verification code
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("resendRecoveryEmailAddressCode")
data class TdResendRecoveryEmailAddressCode(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPasswordState> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdResendRecoveryEmailAddressCode {
        return copy(extra = extra.copy(id = id))
    }
}

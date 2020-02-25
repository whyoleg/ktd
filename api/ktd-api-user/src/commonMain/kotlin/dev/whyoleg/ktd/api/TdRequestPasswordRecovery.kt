package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Requests to send a password recovery code to an email address that was previously set up
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("requestPasswordRecovery")
data class TdRequestPasswordRecovery(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdEmailAddressAuthenticationCodeInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRequestPasswordRecovery {
        return copy(extra = extra.copy(id = id))
    }
}

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Requests to send a password recovery code to an email address that was previously set up
 * Works only when the current authorization state is authorizationStateWaitPassword
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("requestAuthenticationPasswordRecovery")
data class TdRequestAuthenticationPasswordRecovery(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRequestAuthenticationPasswordRecovery {
        return copy(extra = extra.copy(id = id))
    }
}

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Re-sends an authentication code to the user
 * Works only when the current authorization state is authorizationStateWaitCode and the next_code_type of the result is not null
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("resendAuthenticationCode")
data class TdResendAuthenticationCode(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdResendAuthenticationCode {
        return copy(extra = extra.copy(id = id))
    }
}

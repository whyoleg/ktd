package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Checks the authentication code
 * Works only when the current authorization state is authorizationStateWaitCode
 *
 * @property code The verification code received via SMS, Telegram message, phone call, or flash call
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("checkAuthenticationCode")
data class TdCheckAuthenticationCode(
    @SerialName("code")
    val code: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCheckAuthenticationCode {
        return copy(extra = extra.copy(id = id))
    }
}

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Recovers the password with a password recovery code sent to an email address that was previously set up
 * Works only when the current authorization state is authorizationStateWaitPassword
 *
 * @property recoveryCode Recovery code to check
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("recoverAuthenticationPassword")
data class TdRecoverAuthenticationPassword(
    @SerialName("recovery_code")
    val recoveryCode: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRecoverAuthenticationPassword {
        return copy(extra = extra.copy(id = id))
    }
}

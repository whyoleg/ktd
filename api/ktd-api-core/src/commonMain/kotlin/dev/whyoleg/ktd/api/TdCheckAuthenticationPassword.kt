package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Checks the authentication password for correctness
 * Works only when the current authorization state is authorizationStateWaitPassword
 *
 * @property password The password to check
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("checkAuthenticationPassword")
data class TdCheckAuthenticationPassword(
    @SerialName("password")
    val password: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCheckAuthenticationPassword {
        return copy(extra = extra.copy(id = id))
    }
}

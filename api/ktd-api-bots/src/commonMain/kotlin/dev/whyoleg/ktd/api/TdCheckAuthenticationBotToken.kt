package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Checks the authentication token of a bot
 * Works only when the current authorization state is authorizationStateWaitPhoneNumber
 * Can be used instead of setAuthenticationPhoneNumber and checkAuthenticationCode to log in
 *
 * @property token The bot token
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("checkAuthenticationBotToken")
data class TdCheckAuthenticationBotToken(
    @SerialName("token")
    val token: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCheckAuthenticationBotToken {
        return copy(extra = extra.copy(id = id))
    }
}

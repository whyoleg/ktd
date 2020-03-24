package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a Telegram Passport authorization form for sharing data with a service
 *
 * @property botUserId User identifier of the service's bot
 * @property scope Telegram Passport element types requested by the service
 * @property publicKey Service's public_key
 * @property nonce Authorization form nonce provided by the service
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getPassportAuthorizationForm")
data class TdGetPassportAuthorizationForm(
    @SerialName("bot_user_id")
    val botUserId: Int = 0,
    @SerialName("scope")
    val scope: String? = null,
    @SerialName("public_key")
    val publicKey: String? = null,
    @SerialName("nonce")
    val nonce: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPassportAuthorizationForm> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetPassportAuthorizationForm {
        return copy(extra = extra.copy(id = id))
    }
}

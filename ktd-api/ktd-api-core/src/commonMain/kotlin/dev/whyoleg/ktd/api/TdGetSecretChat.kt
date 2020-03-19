package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a secret chat by its identifier
 * This is an offline request
 *
 * @property secretChatId Secret chat identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getSecretChat")
data class TdGetSecretChat(
    @SerialName("secret_chat_id")
    val secretChatId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdSecretChat> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetSecretChat {
        return copy(extra = extra.copy(id = id))
    }
}

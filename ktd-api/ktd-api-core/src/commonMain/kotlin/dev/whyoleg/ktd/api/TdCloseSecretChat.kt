package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Closes a secret chat, effectively transferring its state to secretChatStateClosed
 *
 * @property secretChatId Secret chat identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("closeSecretChat")
data class TdCloseSecretChat(
    @SerialName("secret_chat_id")
    val secretChatId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCloseSecretChat {
        return copy(extra = extra.copy(id = id))
    }
}

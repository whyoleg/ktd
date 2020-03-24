package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns an existing chat corresponding to a known secret chat
 *
 * @property secretChatId Secret chat identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("createSecretChat")
data class TdCreateSecretChat(
    @SerialName("secret_chat_id")
    val secretChatId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChat> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCreateSecretChat {
        return copy(extra = extra.copy(id = id))
    }
}

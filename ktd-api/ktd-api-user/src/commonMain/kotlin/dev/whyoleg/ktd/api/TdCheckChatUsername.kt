package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Checks whether a username can be set for a chat
 *
 * @property chatId Chat identifier
 *                  Should be identifier of a supergroup chat, or a channel chat, or a private chat with self, or zero if chat is being created
 * @property username Username to be checked
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("checkChatUsername")
data class TdCheckChatUsername(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("username")
    val username: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdCheckChatUsernameResult> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCheckChatUsername {
        return copy(extra = extra.copy(id = id))
    }
}

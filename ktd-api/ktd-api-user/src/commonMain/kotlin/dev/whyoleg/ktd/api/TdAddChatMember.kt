package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds a new member to a chat
 * Members can't be added to private or secret chats
 * Members will not be added until the chat state has been synchronized with the server
 *
 * @property chatId Chat identifier
 * @property userId Identifier of the user
 * @property forwardLimit The number of earlier messages from the chat to be forwarded to the new member
 *                        Ignored for supergroups and channels
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("addChatMember")
data class TdAddChatMember(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("forward_limit")
    val forwardLimit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAddChatMember {
        return copy(extra = extra.copy(id = id))
    }
}

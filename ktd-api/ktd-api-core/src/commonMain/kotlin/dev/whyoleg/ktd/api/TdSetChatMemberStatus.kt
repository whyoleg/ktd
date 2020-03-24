package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the status of a chat member, needs appropriate privileges
 * This function is currently not suitable for adding new members to the chat and transferring chat ownership
 * Instead, use addChatMember or transferChatOwnership
 * The chat member status will not be changed until it has been synchronized with the server
 *
 * @property chatId Chat identifier
 * @property userId User identifier
 * @property status The new status of the member in the chat
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setChatMemberStatus")
data class TdSetChatMemberStatus(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("status")
    val status: TdChatMemberStatus? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetChatMemberStatus {
        return copy(extra = extra.copy(id = id))
    }
}

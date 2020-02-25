package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Deletes all messages in the chat
 * Use Chat.can_be_deleted_only_for_self and Chat.can_be_deleted_for_all_users fields to find whether and how the method can be applied to the chat
 *
 * @property chatId Chat identifier
 * @property removeFromChatList Pass true if the chat should be removed from the chat list
 * @property revoke Pass true to try to delete chat history for all users
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("deleteChatHistory")
data class TdDeleteChatHistory(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("remove_from_chat_list")
    val removeFromChatList: Boolean = false,
    @SerialName("revoke")
    val revoke: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDeleteChatHistory {
        return copy(extra = extra.copy(id = id))
    }
}

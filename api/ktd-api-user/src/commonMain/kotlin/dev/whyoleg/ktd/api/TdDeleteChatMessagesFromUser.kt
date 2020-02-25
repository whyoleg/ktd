package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Deletes all messages sent by the specified user to a chat
 * Supported only for supergroups
 * Requires can_delete_messages administrator privileges
 *
 * @property chatId Chat identifier
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("deleteChatMessagesFromUser")
data class TdDeleteChatMessagesFromUser(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDeleteChatMessagesFromUser {
        return copy(extra = extra.copy(id = id))
    }
}

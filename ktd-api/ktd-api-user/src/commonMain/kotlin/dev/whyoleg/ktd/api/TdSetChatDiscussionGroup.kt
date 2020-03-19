package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the discussion group of a channel chat
 * Requires can_change_info rights in the channel if it is specified
 *
 * @property chatId Identifier of the channel chat
 *                  Pass 0 to remove a link from the supergroup passed in the second argument to a linked channel chat (requires can_pin_messages rights in the supergroup)
 * @property discussionChatId Identifier of a new channel's discussion group
 *                            Use 0 to remove the discussion group
 *                            Use the method getSuitableDiscussionChats to find all suitable groups
 *                            Basic group chats needs to be first upgraded to supergroup chats
 *                            If new chat members don't have access to old messages in the supergroup, then toggleSupergroupIsAllHistoryAvailable needs to be used first to change that
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setChatDiscussionGroup")
data class TdSetChatDiscussionGroup(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("discussion_chat_id")
    val discussionChatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetChatDiscussionGroup {
        return copy(extra = extra.copy(id = id))
    }
}

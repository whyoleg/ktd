package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

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
suspend fun SuspendTdClient.setChatDiscussionGroup(
    chatId: Long = 0L,
    discussionChatId: Long = 0L,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetChatDiscussionGroup(chatId, discussionChatId, extra))

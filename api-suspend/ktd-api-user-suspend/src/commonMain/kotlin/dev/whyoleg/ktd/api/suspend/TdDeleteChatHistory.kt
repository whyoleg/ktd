package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Deletes all messages in the chat
 * Use Chat.can_be_deleted_only_for_self and Chat.can_be_deleted_for_all_users fields to find whether and how the method can be applied to the chat
 *
 * @property chatId Chat identifier
 * @property removeFromChatList Pass true if the chat should be removed from the chat list
 * @property revoke Pass true to try to delete chat history for all users
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.deleteChatHistory(
    chatId: Long = 0L,
    removeFromChatList: Boolean = false,
    revoke: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdDeleteChatHistory(chatId, removeFromChatList, revoke, extra))

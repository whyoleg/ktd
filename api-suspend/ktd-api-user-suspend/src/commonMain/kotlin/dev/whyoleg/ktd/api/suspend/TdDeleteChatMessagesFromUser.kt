package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Deletes all messages sent by the specified user to a chat
 * Supported only for supergroups
 * Requires can_delete_messages administrator privileges
 *
 * @property chatId Chat identifier
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.deleteChatMessagesFromUser(
    chatId: Long = 0L,
    userId: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdDeleteChatMessagesFromUser(chatId, userId, extra))

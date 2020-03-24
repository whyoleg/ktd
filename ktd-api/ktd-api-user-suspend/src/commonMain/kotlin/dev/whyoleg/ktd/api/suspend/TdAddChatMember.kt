package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

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
suspend fun SuspendTdClient.addChatMember(
    chatId: Long = 0L,
    userId: Int = 0,
    forwardLimit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdAddChatMember(chatId, userId, forwardLimit, extra))

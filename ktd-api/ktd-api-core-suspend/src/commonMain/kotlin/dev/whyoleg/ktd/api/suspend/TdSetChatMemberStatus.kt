package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

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
suspend fun SuspendTdClient.setChatMemberStatus(
    chatId: Long = 0L,
    userId: Int = 0,
    status: TdChatMemberStatus? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetChatMemberStatus(chatId, userId, status, extra))

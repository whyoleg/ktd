package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the owner of a chat
 * The current user must be a current owner of the chat
 * Use the method canTransferOwnership to check whether the ownership can be transferred from the current session
 * Available only for supergroups and channel chats
 *
 * @property chatId Chat identifier
 * @property userId Identifier of the user to which transfer the ownership
 *                  The ownership can't be transferred to a bot or to a deleted user
 * @property password The password of the current user
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.transferChatOwnership(
    chatId: Long = 0L,
    userId: Int = 0,
    password: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdTransferChatOwnership(chatId, userId, password, extra))

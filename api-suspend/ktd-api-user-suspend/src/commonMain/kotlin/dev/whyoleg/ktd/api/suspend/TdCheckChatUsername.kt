package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Checks whether a username can be set for a chat
 *
 * @property chatId Chat identifier
 *                  Should be identifier of a supergroup chat, or a channel chat, or a private chat with self, or zero if chat is being created
 * @property username Username to be checked
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.checkChatUsername(
    chatId: Long = 0L,
    username: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdCheckChatUsernameResult = exec(TdCheckChatUsername(chatId, username, extra))

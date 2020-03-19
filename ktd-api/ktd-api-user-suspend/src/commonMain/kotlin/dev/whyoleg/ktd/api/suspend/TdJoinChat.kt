package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds current user as a new member to a chat
 * Private and secret chats can't be joined using this method
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.joinChat(chatId: Long = 0L, extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdJoinChat(chatId, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds a chat to the list of recently found chats
 * The chat is added to the beginning of the list
 * If the chat is already in the list, it will be removed from the list first
 *
 * @property chatId Identifier of the chat to add
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.addRecentlyFoundChat(chatId: Long = 0L, extra: TdExtra = TdExtra.EMPTY):
        TdOk = exec(TdAddRecentlyFoundChat(chatId, extra))

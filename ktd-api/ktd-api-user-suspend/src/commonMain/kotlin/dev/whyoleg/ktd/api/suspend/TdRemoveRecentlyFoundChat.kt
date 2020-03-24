package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes a chat from the list of recently found chats
 *
 * @property chatId Identifier of the chat to be removed
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.removeRecentlyFoundChat(chatId: Long = 0L, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdRemoveRecentlyFoundChat(chatId, extra))

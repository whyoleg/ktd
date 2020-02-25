package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a pinned chat message
 *
 * @property chatId Identifier of the chat the message belongs to
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getChatPinnedMessage(chatId: Long = 0L, extra: TdExtra = TdExtra.EMPTY):
        TdMessage = exec(TdGetChatPinnedMessage(chatId, extra))

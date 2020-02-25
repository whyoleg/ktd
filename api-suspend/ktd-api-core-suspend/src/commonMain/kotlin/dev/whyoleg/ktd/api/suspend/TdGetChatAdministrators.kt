package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a list of administrators of the chat with their custom titles
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getChatAdministrators(chatId: Long = 0L, extra: TdExtra =
        TdExtra.EMPTY): TdChatAdministrators = exec(TdGetChatAdministrators(chatId, extra))

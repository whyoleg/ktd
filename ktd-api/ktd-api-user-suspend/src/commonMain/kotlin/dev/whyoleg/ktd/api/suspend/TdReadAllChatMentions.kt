package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Marks all mentions in a chat as read
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.readAllChatMentions(chatId: Long = 0L, extra: TdExtra = TdExtra.EMPTY):
        TdOk = exec(TdReadAllChatMentions(chatId, extra))

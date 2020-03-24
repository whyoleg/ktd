package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns all scheduled messages in a chat
 * The messages are returned in a reverse chronological order (i.e., in order of decreasing message_id)
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getChatScheduledMessages(chatId: Long = 0L, extra: TdExtra =
        TdExtra.EMPTY): TdMessages = exec(TdGetChatScheduledMessages(chatId, extra))

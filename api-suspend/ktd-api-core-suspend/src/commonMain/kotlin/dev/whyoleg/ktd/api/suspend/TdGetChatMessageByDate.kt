package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the last message sent in a chat no later than the specified date
 *
 * @property chatId Chat identifier
 * @property date Point in time (Unix timestamp) relative to which to search for messages
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getChatMessageByDate(
    chatId: Long = 0L,
    date: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdMessage = exec(TdGetChatMessageByDate(chatId, date, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns approximate number of messages of the specified type in the chat
 *
 * @property chatId Identifier of the chat in which to count messages
 * @property filter Filter for message content
 *                  SearchMessagesFilterEmpty is unsupported in this function
 * @property returnLocal If true, returns count that is available locally without sending network requests, returning -1 if the number of messages is unknown
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getChatMessageCount(
    chatId: Long = 0L,
    filter: TdSearchMessagesFilter? = null,
    returnLocal: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdCount = exec(TdGetChatMessageCount(chatId, filter, returnLocal, extra))

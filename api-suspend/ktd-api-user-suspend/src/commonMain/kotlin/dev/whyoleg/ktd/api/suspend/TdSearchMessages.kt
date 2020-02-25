package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches for messages in all chats except secret chats
 * Returns the results in reverse chronological order (i.e., in order of decreasing (date, chat_id, message_id))
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @property chatList Chat list in which to search messages
 *                    Pass null to search in all chats regardless of their chat list
 * @property query Query to search for
 * @property offsetDate The date of the message starting from which the results should be fetched
 *                      Use 0 or any date in the future to get results from the last message
 * @property offsetChatId The chat identifier of the last found message, or 0 for the first request
 * @property offsetMessageId The message identifier of the last found message, or 0 for the first request
 * @property limit The maximum number of messages to be returned, up to 100
 *                 Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchMessages(
    chatList: TdChatList? = null,
    query: String? = null,
    offsetDate: Int = 0,
    offsetChatId: Long = 0L,
    offsetMessageId: Long = 0L,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdMessages = exec(TdSearchMessages(chatList, query, offsetDate, offsetChatId, offsetMessageId,
        limit, extra))

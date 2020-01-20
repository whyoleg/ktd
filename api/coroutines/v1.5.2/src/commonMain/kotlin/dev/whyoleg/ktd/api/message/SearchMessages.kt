@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Searches for messages in all chats except secret chats
 * Returns the results in reverse chronological order (i.e., in order of decreasing (date, chat_id, message_id))
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @chatList - Chat list in which to search messages
 *             Pass null to search in all chats regardless of their chat list
 * @query - Query to search for
 * @offsetDate - The date of the message starting from which the results should be fetched
 *               Use 0 or any date in the future to get results from the last message
 * @offsetChatId - The chat identifier of the last found message, or 0 for the first request
 * @offsetMessageId - The message identifier of the last found message, or 0 for the first request
 * @limit - The maximum number of messages to be returned, up to 100
 *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 */
suspend fun TelegramClient.searchMessages(
    chatList: ChatList? = null,
    query: String? = null,
    offsetDate: Int = 0,
    offsetChatId: Long = 0L,
    offsetMessageId: Long = 0L,
    limit: Int = 0
): Messages = message(
    SearchMessages(
        chatList,
        query,
        offsetDate,
        offsetChatId,
        offsetMessageId,
        limit
    )
)

/**
 * Searches for messages in all chats except secret chats
 * Returns the results in reverse chronological order (i.e., in order of decreasing (date, chat_id, message_id))
 * For optimal performance the number of returned messages is chosen by the library
 */
suspend fun TelegramClient.message(
    f: SearchMessages
): Messages = exec(f) as Messages

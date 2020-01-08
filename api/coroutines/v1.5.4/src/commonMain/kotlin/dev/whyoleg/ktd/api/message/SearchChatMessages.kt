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
 * Searches for messages with given words in the chat
 * Returns the results in reverse chronological order, i.e
 * In order of decreasing message_id
 * Cannot be used in secret chats with a non-empty query (searchSecretMessages should be used instead), or without an enabled message database
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @chatId - Identifier of the chat in which to search messages
 * @query - Query to search for
 * @senderUserId - If not 0, only messages sent by the specified user will be returned
 *                 Not supported in secret chats
 * @fromMessageId - Identifier of the message starting from which history must be fetched
 *                  Use 0 to get results from the last message
 * @offset - Specify 0 to get results from exactly the from_message_id or a negative offset to get the specified message and some newer messages
 * @limit - The maximum number of messages to be returned
 *          Must be positive and can't be greater than 100
 *          If the offset is negative, the limit must be greater than -offset
 *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @filter - Filter for message content in the search results
 */
suspend fun TelegramClient.searchChatMessages(
    chatId: Long = 0L,
    query: String? = null,
    senderUserId: Int = 0,
    fromMessageId: Long = 0L,
    offset: Int = 0,
    limit: Int = 0,
    filter: SearchMessagesFilter? = null
): Messages = message(
    SearchChatMessages(
        chatId,
        query,
        senderUserId,
        fromMessageId,
        offset,
        limit,
        filter
    )
)

/**
 * Searches for messages with given words in the chat
 * Returns the results in reverse chronological order, i.e
 * In order of decreasing message_id
 * Cannot be used in secret chats with a non-empty query (searchSecretMessages should be used instead), or without an enabled message database
 * For optimal performance the number of returned messages is chosen by the library
 */
suspend fun TelegramClient.message(
    f: SearchChatMessages
): Messages = exec(f) as Messages

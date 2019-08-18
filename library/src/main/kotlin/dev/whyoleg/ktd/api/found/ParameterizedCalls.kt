@file:Suppress("unused")

package dev.whyoleg.ktd.api.found

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Adds a chat to the list of recently found chats. The chat is added to the beginning of the list. If the chat is already in the list, it will be removed from the list first
 *
 * @chatId - Identifier of the chat to add
 */
suspend fun TelegramClient.addRecentlyFoundChat(
    chatId: Long
): Ok = found(
    AddRecentlyFoundChat(
        chatId
    )
)

/**
 * Removes a chat from the list of recently found chats
 *
 * @chatId - Identifier of the chat to be removed
 */
suspend fun TelegramClient.removeRecentlyFoundChat(
    chatId: Long
): Ok = found(
    RemoveRecentlyFoundChat(
        chatId
    )
)

/**
 * Clears the list of recently found chats
 */
suspend fun TelegramClient.clearRecentlyFoundChats(): Ok = found(
    ClearRecentlyFoundChats()
)

/**
 * Searches for messages in secret chats. Returns the results in reverse chronological order. For optimal performance the number of returned messages is chosen by the library
 *
 * @chatId - Identifier of the chat in which to search. Specify 0 to search in all secret chats
 * @query - Query to search for. If empty, searchChatMessages should be used instead
 * @fromSearchId - The identifier from the result of a previous request, use 0 to get results from the last message
 * @limit - Maximum number of messages to be returned; up to 100. Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @filter - A filter for the content of messages in the search results
 */
suspend fun TelegramClient.searchSecretMessages(
    chatId: Long,
    query: String,
    fromSearchId: Long,
    limit: Int,
    filter: SearchMessagesFilter
): FoundMessages = found(
    SearchSecretMessages(
        chatId,
        query,
        fromSearchId,
        limit,
        filter
    )
)

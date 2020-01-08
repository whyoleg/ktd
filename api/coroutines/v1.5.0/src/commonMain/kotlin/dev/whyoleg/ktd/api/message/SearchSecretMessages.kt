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
 * Searches for messages in secret chats
 * Returns the results in reverse chronological order
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @chatId - Identifier of the chat in which to search
 *           Specify 0 to search in all secret chats
 * @query - Query to search for
 *          If empty, searchChatMessages should be used instead
 * @fromSearchId - The identifier from the result of a previous request, use 0 to get results from the last message
 * @limit - Maximum number of messages to be returned
 *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @filter - A filter for the content of messages in the search results
 */
suspend fun TelegramClient.searchSecretMessages(
    chatId: Long = 0L,
    query: String? = null,
    fromSearchId: Long = 0L,
    limit: Int = 0,
    filter: SearchMessagesFilter? = null
): FoundMessages = message(
    SearchSecretMessages(
        chatId,
        query,
        fromSearchId,
        limit,
        filter
    )
)

/**
 * Searches for messages in secret chats
 * Returns the results in reverse chronological order
 * For optimal performance the number of returned messages is chosen by the library
 */
suspend fun TelegramClient.message(
    f: SearchSecretMessages
): FoundMessages = exec(f) as FoundMessages

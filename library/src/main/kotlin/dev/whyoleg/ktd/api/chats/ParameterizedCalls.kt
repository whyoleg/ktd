@file:Suppress("unused")

package dev.whyoleg.ktd.api.chats

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns an ordered list of chats. Chats are sorted by the pair (order, chat_id) in decreasing order. (For example, to get a list of chats from the beginning, the offsetOrder should be equal to a biggest signed 64-bit number 9223372036854775807 == 2^63 - 1).
 * For optimal performance the number of returned chats is chosen by the library.
 *
 * @offsetOrder - Chat order to return chats from
 * @offsetChatId - Chat identifier to return chats from
 * @limit - The maximum number of chats to be returned. It is possible that fewer chats than the limit are returned even if the end of the list is not reached
 */
suspend fun TelegramClient.getChats(
    offsetOrder: Long,
    offsetChatId: Long,
    limit: Int
): Chats = chats(
    GetChats(
        offsetOrder,
        offsetChatId,
        limit
    )
)

/**
 * Searches public chats by looking for specified query in their username and title. Currently only private chats, supergroups and channels can be public. Returns a meaningful number of results. Returns nothing if the length of the searched username prefix is less than 5. Excludes private chats with contacts and chats from the chat list from the results
 *
 * @query - Query to search for
 */
suspend fun TelegramClient.searchPublicChats(
    query: String
): Chats = chats(
    SearchPublicChats(
        query
    )
)

/**
 * Searches for the specified query in the title and username of already known chats, this is an offline request. Returns chats in the order seen in the chat list
 *
 * @query - Query to search for. If the query is empty, returns up to 20 recently found chats
 * @limit - Maximum number of chats to be returned
 */
suspend fun TelegramClient.searchChats(
    query: String,
    limit: Int
): Chats = chats(
    SearchChats(
        query,
        limit
    )
)

/**
 * Searches for the specified query in the title and username of already known chats via request to the server. Returns chats in the order seen in the chat list
 *
 * @query - Query to search for
 * @limit - Maximum number of chats to be returned
 */
suspend fun TelegramClient.searchChatsOnServer(
    query: String,
    limit: Int
): Chats = chats(
    SearchChatsOnServer(
        query,
        limit
    )
)

/**
 * Returns a list of frequently used chats. Supported only if the chat info database is enabled
 *
 * @category - Category of chats to be returned
 * @limit - Maximum number of chats to be returned; up to 30
 */
suspend fun TelegramClient.getTopChats(
    category: TopChatCategory,
    limit: Int
): Chats = chats(
    GetTopChats(
        category,
        limit
    )
)

/**
 * Returns a list of public chats created by the user
 */
suspend fun TelegramClient.getCreatedPublicChats(): Chats = chats(
    GetCreatedPublicChats()
)

/**
 * Returns a list of common group chats with a given user. Chats are sorted by their type and creation date
 *
 * @userId - User identifier
 * @offsetChatId - Chat identifier starting from which to return chats; use 0 for the first request
 * @limit - Maximum number of chats to be returned; up to 100
 */
suspend fun TelegramClient.getGroupsInCommon(
    userId: Int,
    offsetChatId: Long,
    limit: Int
): Chats = chats(
    GetGroupsInCommon(
        userId,
        offsetChatId,
        limit
    )
)

/**
 * Returns list of chats with non-default notification settings
 *
 * @scope - If specified, only chats from the specified scope will be returned
 * @compareSound - If true, also chats with non-default sound will be returned
 */
suspend fun TelegramClient.getChatNotificationSettingsExceptions(
    scope: NotificationSettingsScope,
    compareSound: Boolean
): Chats = chats(
    GetChatNotificationSettingsExceptions(
        scope,
        compareSound
    )
)

/**
 * Changes the order of pinned chats
 *
 * @chatIds - The new list of pinned chats
 */
suspend fun TelegramClient.setPinnedChats(
    chatIds: LongArray
): Ok = chats(
    SetPinnedChats(
        chatIds
    )
)

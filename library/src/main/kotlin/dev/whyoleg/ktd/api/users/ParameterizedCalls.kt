@file:Suppress("unused")

package dev.whyoleg.ktd.api.users

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a list of users who are administrators of the chat
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.getChatAdministrators(
    chatId: Long
): Users = users(
    GetChatAdministrators(
        chatId
    )
)

/**
 * Returns users that were blocked by the current user
 *
 * @offset - Number of users to skip in the result; must be non-negative
 * @limit - Maximum number of users to return; up to 100
 */
suspend fun TelegramClient.getBlockedUsers(
    offset: Int,
    limit: Int
): Users = users(
    GetBlockedUsers(
        offset,
        limit
    )
)

/**
 * Returns all user contacts
 */
suspend fun TelegramClient.getContacts(): Users = users(
    GetContacts()
)

/**
 * Searches for the specified query in the first names, last names and usernames of the known user contacts
 *
 * @query - Query to search for; may be empty to return all contacts
 * @limit - Maximum number of users to be returned
 */
suspend fun TelegramClient.searchContacts(
    query: String,
    limit: Int
): Users = users(
    SearchContacts(
        query,
        limit
    )
)

/**
 * Returns up to 20 recently used inline bots in the order of their last usage
 */
suspend fun TelegramClient.getRecentInlineBots(): Users = users(
    GetRecentInlineBots()
)

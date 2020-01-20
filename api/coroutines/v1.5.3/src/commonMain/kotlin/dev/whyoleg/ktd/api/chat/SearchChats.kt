@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.chat

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Searches for the specified query in the title and username of already known chats, this is an offline request
 * Returns chats in the order seen in the chat list
 *
 * @query - Query to search for
 *          If the query is empty, returns up to 20 recently found chats
 * @limit - Maximum number of chats to be returned
 */
suspend fun TelegramClient.searchChats(
    query: String? = null,
    limit: Int = 0
): Chats = chat(
    SearchChats(
        query,
        limit
    )
)

/**
 * Searches for the specified query in the title and username of already known chats, this is an offline request
 * Returns chats in the order seen in the chat list
 */
suspend fun TelegramClient.chat(
    f: SearchChats
): Chats = exec(f) as Chats

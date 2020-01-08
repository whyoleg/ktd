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
 * Searches for the specified query in the title and username of already known chats via request to the server
 * Returns chats in the order seen in the chat list
 *
 * @query - Query to search for
 * @limit - Maximum number of chats to be returned
 */
suspend fun TelegramClient.searchChatsOnServer(
    query: String? = null,
    limit: Int = 0
): Chats = chat(
    SearchChatsOnServer(
        query,
        limit
    )
)

/**
 * Searches for the specified query in the title and username of already known chats via request to the server
 * Returns chats in the order seen in the chat list
 */
suspend fun TelegramClient.chat(
    f: SearchChatsOnServer
): Chats = exec(f) as Chats

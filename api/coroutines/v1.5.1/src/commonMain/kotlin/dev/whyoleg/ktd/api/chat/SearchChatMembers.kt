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
 * Searches for a specified query in the first name, last name and username of the members of a specified chat
 * Requires administrator rights in channels
 *
 * @chatId - Chat identifier
 * @query - Query to search for
 * @limit - The maximum number of users to be returned
 * @filter - The type of users to return
 *           By default, chatMembersFilterMembers
 */
suspend fun TelegramClient.searchChatMembers(
    chatId: Long = 0L,
    query: String? = null,
    limit: Int = 0,
    filter: ChatMembersFilter? = null
): ChatMembers = chat(
    SearchChatMembers(
        chatId,
        query,
        limit,
        filter
    )
)

/**
 * Searches for a specified query in the first name, last name and username of the members of a specified chat
 * Requires administrator rights in channels
 */
suspend fun TelegramClient.chat(
    f: SearchChatMembers
): ChatMembers = exec(f) as ChatMembers

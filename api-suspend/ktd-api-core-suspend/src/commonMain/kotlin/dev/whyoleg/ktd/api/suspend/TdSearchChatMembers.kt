package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches for a specified query in the first name, last name and username of the members of a specified chat
 * Requires administrator rights in channels
 *
 * @property chatId Chat identifier
 * @property query Query to search for
 * @property limit The maximum number of users to be returned
 * @property filter The type of users to return
 *                  By default, chatMembersFilterMembers
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchChatMembers(
    chatId: Long = 0L,
    query: String? = null,
    limit: Int = 0,
    filter: TdChatMembersFilter? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdChatMembers = exec(TdSearchChatMembers(chatId, query, limit, filter, extra))

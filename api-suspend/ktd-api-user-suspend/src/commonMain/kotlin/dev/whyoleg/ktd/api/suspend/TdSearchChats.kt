package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches for the specified query in the title and username of already known chats, this is an offline request
 * Returns chats in the order seen in the chat list
 *
 * @property query Query to search for
 *                 If the query is empty, returns up to 20 recently found chats
 * @property limit The maximum number of chats to be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchChats(
    query: String? = null,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdChats = exec(TdSearchChats(query, limit, extra))

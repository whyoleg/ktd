package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches for the specified query in the title and username of already known chats via request to the server
 * Returns chats in the order seen in the chat list
 *
 * @property query Query to search for
 * @property limit The maximum number of chats to be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchChatsOnServer(
    query: String? = null,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdChats = exec(TdSearchChatsOnServer(query, limit, extra))

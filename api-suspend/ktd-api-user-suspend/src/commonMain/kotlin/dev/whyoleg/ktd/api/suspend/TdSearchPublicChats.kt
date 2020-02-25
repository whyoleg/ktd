package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches public chats by looking for specified query in their username and title
 * Currently only private chats, supergroups and channels can be public
 * Returns a meaningful number of results
 * Returns nothing if the length of the searched username prefix is less than 5
 * Excludes private chats with contacts and chats from the chat list from the results
 *
 * @property query Query to search for
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchPublicChats(query: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdChats = exec(TdSearchPublicChats(query, extra))

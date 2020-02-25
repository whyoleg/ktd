package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches for the specified query in the first names, last names and usernames of the known user contacts
 *
 * @property query Query to search for
 *                 May be empty to return all contacts
 * @property limit The maximum number of users to be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchContacts(
    query: String? = null,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdUsers = exec(TdSearchContacts(query, limit, extra))

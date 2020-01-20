@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.user

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Searches for the specified query in the first names, last names and usernames of the known user contacts
 *
 * @query - Query to search for
 *          May be empty to return all contacts
 * @limit - Maximum number of users to be returned
 */
suspend fun TelegramClient.searchContacts(
    query: String? = null,
    limit: Int = 0
): Users = user(
    SearchContacts(
        query,
        limit
    )
)

/**
 * Searches for the specified query in the first names, last names and usernames of the known user contacts
 */
suspend fun TelegramClient.user(
    f: SearchContacts
): Users = exec(f) as Users

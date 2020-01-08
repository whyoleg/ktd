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
 * Returns users that were blocked by the current user
 *
 * @offset - Number of users to skip in the result
 * @limit - Maximum number of users to return
 */
suspend fun TelegramClient.getBlockedUsers(
    offset: Int = 0,
    limit: Int = 0
): Users = user(
    GetBlockedUsers(
        offset,
        limit
    )
)

/**
 * Returns users that were blocked by the current user
 */
suspend fun TelegramClient.user(
    f: GetBlockedUsers
): Users = exec(f) as Users

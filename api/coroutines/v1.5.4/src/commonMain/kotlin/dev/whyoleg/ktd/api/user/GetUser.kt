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
 * Returns information about a user by their identifier
 * This is an offline request if the current user is not a bot
 *
 * @userId - User identifier
 */
suspend fun TelegramClient.getUser(
    userId: Int = 0
): User = user(
    GetUser(
        userId
    )
)

/**
 * Returns information about a user by their identifier
 * This is an offline request if the current user is not a bot
 */
suspend fun TelegramClient.user(
    f: GetUser
): User = exec(f) as User

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
 * Returns full information about a user by their identifier
 *
 * @userId - User identifier
 */
suspend fun TelegramClient.getUserFullInfo(
    userId: Int = 0
): UserFullInfo = user(
    GetUserFullInfo(
        userId
    )
)

/**
 * Returns full information about a user by their identifier
 */
suspend fun TelegramClient.user(
    f: GetUserFullInfo
): UserFullInfo = exec(f) as UserFullInfo

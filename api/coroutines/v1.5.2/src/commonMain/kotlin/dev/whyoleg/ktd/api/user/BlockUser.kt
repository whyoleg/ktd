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
 * Adds a user to the blacklist
 *
 * @userId - User identifier
 */
suspend fun TelegramClient.blockUser(
    userId: Int = 0
): Ok = user(
    BlockUser(
        userId
    )
)

/**
 * Adds a user to the blacklist
 */
suspend fun TelegramClient.user(
    f: BlockUser
): Ok = exec(f) as Ok

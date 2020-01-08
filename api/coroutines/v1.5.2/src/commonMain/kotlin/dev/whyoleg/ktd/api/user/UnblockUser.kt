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
 * Removes a user from the blacklist
 *
 * @userId - User identifier
 */
suspend fun TelegramClient.unblockUser(
    userId: Int = 0
): Ok = user(
    UnblockUser(
        userId
    )
)

/**
 * Removes a user from the blacklist
 */
suspend fun TelegramClient.user(
    f: UnblockUser
): Ok = exec(f) as Ok

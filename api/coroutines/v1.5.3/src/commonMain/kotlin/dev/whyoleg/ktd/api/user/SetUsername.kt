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
 * Changes the username of the current user
 * If something changes, updateUser will be sent
 *
 * @username - The new value of the username
 *             Use an empty string to remove the username
 */
suspend fun TelegramClient.setUsername(
    username: String? = null
): Ok = user(
    SetUsername(
        username
    )
)

/**
 * Changes the username of the current user
 * If something changes, updateUser will be sent
 */
suspend fun TelegramClient.user(
    f: SetUsername
): Ok = exec(f) as Ok

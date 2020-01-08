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
 * Returns the current user
 */
suspend fun TelegramClient.getMe(): User = user(
    GetMe()
)

/**
 * Returns the current user
 */
suspend fun TelegramClient.user(
    f: GetMe
): User = exec(f) as User

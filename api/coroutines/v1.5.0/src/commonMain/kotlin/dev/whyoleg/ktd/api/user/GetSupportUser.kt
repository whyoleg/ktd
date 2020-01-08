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
 * Returns a user that can be contacted to get support
 */
suspend fun TelegramClient.getSupportUser(): User = user(
    GetSupportUser()
)

/**
 * Returns a user that can be contacted to get support
 */
suspend fun TelegramClient.user(
    f: GetSupportUser
): User = exec(f) as User

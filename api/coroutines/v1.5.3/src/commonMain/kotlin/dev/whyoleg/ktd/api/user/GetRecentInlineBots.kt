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
 * Returns up to 20 recently used inline bots in the order of their last usage
 */
suspend fun TelegramClient.getRecentInlineBots(): Users = user(
    GetRecentInlineBots()
)

/**
 * Returns up to 20 recently used inline bots in the order of their last usage
 */
suspend fun TelegramClient.user(
    f: GetRecentInlineBots
): Users = exec(f) as Users

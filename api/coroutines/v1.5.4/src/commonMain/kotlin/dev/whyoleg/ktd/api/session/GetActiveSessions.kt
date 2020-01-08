@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.session

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns all active sessions of the current user
 */
suspend fun TelegramClient.getActiveSessions(): Sessions = session(
    GetActiveSessions()
)

/**
 * Returns all active sessions of the current user
 */
suspend fun TelegramClient.session(
    f: GetActiveSessions
): Sessions = exec(f) as Sessions

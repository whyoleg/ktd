@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.util

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Closes the TDLib instance
 * All databases will be flushed to disk and properly closed
 * After the close completes, updateAuthorizationState with authorizationStateClosed will be sent
 */
suspend fun TelegramClient.util(
    f: Close
): Ok = exec(f) as Ok

/**
 * Closes the TDLib instance, destroying all local data without a proper logout
 * The current user session will remain in the list of all active sessions
 * All local data will be destroyed
 * After the destruction completes updateAuthorizationState with authorizationStateClosed will be sent
 */
suspend fun TelegramClient.util(
    f: Destroy
): Ok = exec(f) as Ok

/**
 * Returns t.me URLs recently visited by a newly registered user
 */
suspend fun TelegramClient.util(
    f: GetRecentlyVisitedTMeUrls
): TMeUrls = exec(f) as TMeUrls

/**
 * Succeeds after a specified amount of time has passed
 * Can be called before authorization
 * Can be called before initialization
 */
suspend fun TelegramClient.util(
    f: SetAlarm
): Ok = exec(f) as Ok

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
suspend fun TelegramClient.session(
    f: GetActiveSessions
): Sessions = execRaw(f) as Sessions

/**
 * Terminates a session of the current user
 */
suspend fun TelegramClient.session(
    f: TerminateSession
): Ok = execRaw(f) as Ok

/**
 * Terminates all other sessions of the current user
 */
suspend fun TelegramClient.session(
    f: TerminateAllOtherSessions
): Ok = execRaw(f) as Ok

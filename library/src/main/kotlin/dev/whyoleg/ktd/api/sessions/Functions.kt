@file:Suppress("unused")

package dev.whyoleg.ktd.api.sessions

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns all active sessions of the current user
 */
suspend fun TelegramClient.sessions(
    f: GetActiveSessions
): Sessions = execRaw(f) as Sessions

/**
 * Terminates all other sessions of the current user
 */
suspend fun TelegramClient.sessions(
    f: TerminateAllOtherSessions
): Ok = execRaw(f) as Ok

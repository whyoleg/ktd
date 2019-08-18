@file:Suppress("unused")

package dev.whyoleg.ktd.api.sessions

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns all active sessions of the current user
 */
suspend fun TelegramClient.getActiveSessions(): Sessions = sessions(
    GetActiveSessions()
)

/**
 * Terminates all other sessions of the current user
 */
suspend fun TelegramClient.terminateAllOtherSessions(): Ok = sessions(
    TerminateAllOtherSessions()
)

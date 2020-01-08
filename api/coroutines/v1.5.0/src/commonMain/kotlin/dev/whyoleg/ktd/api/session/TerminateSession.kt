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
 * Terminates a session of the current user
 *
 * @sessionId - Session identifier
 */
suspend fun TelegramClient.terminateSession(
    sessionId: Long = 0L
): Ok = session(
    TerminateSession(
        sessionId
    )
)

/**
 * Terminates a session of the current user
 */
suspend fun TelegramClient.session(
    f: TerminateSession
): Ok = exec(f) as Ok

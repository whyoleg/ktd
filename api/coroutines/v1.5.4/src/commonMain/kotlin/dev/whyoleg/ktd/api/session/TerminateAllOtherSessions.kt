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
 * Terminates all other sessions of the current user
 */
suspend fun TelegramClient.terminateAllOtherSessions(): Ok = session(
    TerminateAllOtherSessions()
)

/**
 * Terminates all other sessions of the current user
 */
suspend fun TelegramClient.session(
    f: TerminateAllOtherSessions
): Ok = exec(f) as Ok

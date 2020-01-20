@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns all active live locations that should be updated by the client
 * The list is persistent across application restarts only if the message database is used
 */
suspend fun TelegramClient.getActiveLiveLocationMessages(): Messages = message(
    GetActiveLiveLocationMessages()
)

/**
 * Returns all active live locations that should be updated by the client
 * The list is persistent across application restarts only if the message database is used
 */
suspend fun TelegramClient.message(
    f: GetActiveLiveLocationMessages
): Messages = exec(f) as Messages

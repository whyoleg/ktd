@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.log

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Saves application log event on the server
 * Can be called before authorization
 *
 * @type - Event type
 * @chatId - Optional chat identifier, associated with the event
 * @data - The log event data
 */
suspend fun TelegramClient.saveApplicationLogEvent(
    type: String? = null,
    chatId: Long = 0L,
    data: JsonValue? = null
): Ok = log(
    SaveApplicationLogEvent(
        type,
        chatId,
        data
    )
)

/**
 * Saves application log event on the server
 * Can be called before authorization
 */
suspend fun TelegramClient.log(
    f: SaveApplicationLogEvent
): Ok = exec(f) as Ok

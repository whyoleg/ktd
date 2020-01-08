@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.sync

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Adds a message to TDLib internal log
 * This is an offline method
 * Can be called before authorization
 *
 * @verbosityLevel - Minimum verbosity level needed for the message to be logged, 0-1023
 * @text - Text of a message to log
 */
suspend fun TelegramClient.addLogMessage(
    verbosityLevel: Int = 0,
    text: String? = null
): Ok = sync(
    AddLogMessage(
        verbosityLevel,
        text
    )
)

/**
 * Adds a message to TDLib internal log
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.sync(
    f: AddLogMessage
): Ok = exec(f) as Ok

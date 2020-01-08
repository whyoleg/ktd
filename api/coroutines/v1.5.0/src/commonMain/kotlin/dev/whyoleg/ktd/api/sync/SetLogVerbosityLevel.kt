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
 * Sets the verbosity level of the internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 *
 * @newVerbosityLevel - New value of the verbosity level for logging
 *                      Value 0 corresponds to fatal errors, value 1 corresponds to errors, value 2 corresponds to warnings and debug warnings, value 3 corresponds to informational, value 4 corresponds to debug, value 5 corresponds to verbose debug, value greater than 5 and up to 1023 can be used to enable even more logging
 */
suspend fun TelegramClient.setLogVerbosityLevel(
    newVerbosityLevel: Int = 0
): Ok = sync(
    SetLogVerbosityLevel(
        newVerbosityLevel
    )
)

/**
 * Sets the verbosity level of the internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.sync(
    f: SetLogVerbosityLevel
): Ok = exec(f) as Ok

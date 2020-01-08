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
 * Returns current verbosity level of the internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.getLogVerbosityLevel(): LogVerbosityLevel = log(
    GetLogVerbosityLevel()
)

/**
 * Returns current verbosity level of the internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.log(
    f: GetLogVerbosityLevel
): LogVerbosityLevel = exec(f) as LogVerbosityLevel

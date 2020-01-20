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
 * Returns current verbosity level of the internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 */
fun TelegramClient.Companion.getLogVerbosityLevel(): LogVerbosityLevel = execute(
    GetLogVerbosityLevel()
)

/**
 * Returns current verbosity level of the internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 */
fun TelegramClient.Companion.execute(
    f: GetLogVerbosityLevel
): LogVerbosityLevel = exec(f) as LogVerbosityLevel

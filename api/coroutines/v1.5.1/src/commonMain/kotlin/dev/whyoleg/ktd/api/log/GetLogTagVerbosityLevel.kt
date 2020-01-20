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
 * Returns current verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 *
 * @tag - Logging tag to change verbosity level
 */
suspend fun TelegramClient.getLogTagVerbosityLevel(
    tag: String? = null
): LogVerbosityLevel = log(
    GetLogTagVerbosityLevel(
        tag
    )
)

/**
 * Returns current verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.log(
    f: GetLogTagVerbosityLevel
): LogVerbosityLevel = exec(f) as LogVerbosityLevel

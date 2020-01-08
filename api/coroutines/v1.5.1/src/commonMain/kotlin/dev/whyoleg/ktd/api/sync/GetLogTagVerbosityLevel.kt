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
 * Returns current verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 *
 * @tag - Logging tag to change verbosity level
 */
suspend fun TelegramClient.getLogTagVerbosityLevel(
    tag: String? = null
): LogVerbosityLevel = sync(
    GetLogTagVerbosityLevel(
        tag
    )
)

/**
 * Returns current verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.sync(
    f: GetLogTagVerbosityLevel
): LogVerbosityLevel = exec(f) as LogVerbosityLevel

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
 * Sets the verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 *
 * @tag - Logging tag to change verbosity level
 * @newVerbosityLevel - New verbosity level
 */
suspend fun TelegramClient.setLogTagVerbosityLevel(
    tag: String? = null,
    newVerbosityLevel: Int = 0
): Ok = sync(
    SetLogTagVerbosityLevel(
        tag,
        newVerbosityLevel
    )
)

/**
 * Sets the verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.sync(
    f: SetLogTagVerbosityLevel
): Ok = exec(f) as Ok

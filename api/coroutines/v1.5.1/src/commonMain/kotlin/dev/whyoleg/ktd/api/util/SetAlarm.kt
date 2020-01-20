@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.util

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Succeeds after a specified amount of time has passed
 * Can be called before authorization
 * Can be called before initialization
 *
 * @seconds - Number of seconds before the function returns
 */
suspend fun TelegramClient.setAlarm(
    seconds: Double = 0.0
): Ok = util(
    SetAlarm(
        seconds
    )
)

/**
 * Succeeds after a specified amount of time has passed
 * Can be called before authorization
 * Can be called before initialization
 */
suspend fun TelegramClient.util(
    f: SetAlarm
): Ok = exec(f) as Ok

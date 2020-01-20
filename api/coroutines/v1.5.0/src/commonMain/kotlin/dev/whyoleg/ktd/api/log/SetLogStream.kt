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
 * Sets new log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 *
 * @logStream - New log stream
 */
suspend fun TelegramClient.setLogStream(
    logStream: LogStream? = null
): Ok = log(
    SetLogStream(
        logStream
    )
)

/**
 * Sets new log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.log(
    f: SetLogStream
): Ok = exec(f) as Ok

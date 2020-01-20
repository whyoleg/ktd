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
 * Sets new log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 *
 * @logStream - New log stream
 */
fun TelegramClient.Companion.setLogStream(
    logStream: LogStream? = null
): Ok = execute(
    SetLogStream(
        logStream
    )
)

/**
 * Sets new log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 */
fun TelegramClient.Companion.execute(
    f: SetLogStream
): Ok = exec(f) as Ok

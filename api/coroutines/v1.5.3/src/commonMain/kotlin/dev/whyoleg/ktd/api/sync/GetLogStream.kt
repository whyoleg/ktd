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
 * Returns information about currently used log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.getLogStream(): LogStream = sync(
    GetLogStream()
)

/**
 * Returns information about currently used log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.sync(
    f: GetLogStream
): LogStream = exec(f) as LogStream

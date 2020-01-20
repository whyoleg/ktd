@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.proxy

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Disables the currently enabled proxy
 * Can be called before authorization
 */
suspend fun TelegramClient.disableProxy(): Ok = proxy(
    DisableProxy()
)

/**
 * Disables the currently enabled proxy
 * Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: DisableProxy
): Ok = exec(f) as Ok

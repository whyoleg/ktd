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
 * Adds a proxy server for network requests
 * Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: AddProxy
): Proxy = exec(f) as Proxy

/**
 * Edits an existing proxy server for network requests
 * Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: EditProxy
): Proxy = exec(f) as Proxy

/**
 * Enables a proxy
 * Only one proxy can be enabled at a time
 * Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: EnableProxy
): Ok = exec(f) as Ok

/**
 * Disables the currently enabled proxy
 * Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: DisableProxy
): Ok = exec(f) as Ok

/**
 * Removes a proxy server
 * Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: RemoveProxy
): Ok = exec(f) as Ok

/**
 * Computes time needed to receive a response from a Telegram server through a proxy
 * Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: PingProxy
): Seconds = exec(f) as Seconds

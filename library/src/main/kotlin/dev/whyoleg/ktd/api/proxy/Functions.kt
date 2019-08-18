@file:Suppress("unused")

package dev.whyoleg.ktd.api.proxy

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Adds a proxy server for network requests. Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: AddProxy
): Proxy = execRaw(f) as Proxy

/**
 * Edits an existing proxy server for network requests. Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: EditProxy
): Proxy = execRaw(f) as Proxy

/**
 * Enables a proxy. Only one proxy can be enabled at a time. Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: EnableProxy
): Ok = execRaw(f) as Ok

/**
 * Disables the currently enabled proxy. Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: DisableProxy
): Ok = execRaw(f) as Ok

/**
 * Removes a proxy server. Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: RemoveProxy
): Ok = execRaw(f) as Ok

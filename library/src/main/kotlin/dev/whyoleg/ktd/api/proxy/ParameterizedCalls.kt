@file:Suppress("unused")

package dev.whyoleg.ktd.api.proxy

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Adds a proxy server for network requests. Can be called before authorization
 *
 * @server - Proxy server IP address
 * @port - Proxy server port
 * @enable - True, if the proxy should be enabled
 * @type - Proxy type
 */
suspend fun TelegramClient.addProxy(
    server: String,
    port: Int,
    enable: Boolean,
    type: ProxyType
): Proxy = proxy(
    AddProxy(
        server,
        port,
        enable,
        type
    )
)

/**
 * Edits an existing proxy server for network requests. Can be called before authorization
 *
 * @proxyId - Proxy identifier
 * @server - Proxy server IP address
 * @port - Proxy server port
 * @enable - True, if the proxy should be enabled
 * @type - Proxy type
 */
suspend fun TelegramClient.editProxy(
    proxyId: Int,
    server: String,
    port: Int,
    enable: Boolean,
    type: ProxyType
): Proxy = proxy(
    EditProxy(
        proxyId,
        server,
        port,
        enable,
        type
    )
)

/**
 * Enables a proxy. Only one proxy can be enabled at a time. Can be called before authorization
 *
 * @proxyId - Proxy identifier
 */
suspend fun TelegramClient.enableProxy(
    proxyId: Int
): Ok = proxy(
    EnableProxy(
        proxyId
    )
)

/**
 * Disables the currently enabled proxy. Can be called before authorization
 */
suspend fun TelegramClient.disableProxy(): Ok = proxy(
    DisableProxy()
)

/**
 * Removes a proxy server. Can be called before authorization
 *
 * @proxyId - Proxy identifier
 */
suspend fun TelegramClient.removeProxy(
    proxyId: Int
): Ok = proxy(
    RemoveProxy(
        proxyId
    )
)

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
 * Edits an existing proxy server for network requests
 * Can be called before authorization
 *
 * @proxyId - Proxy identifier
 * @server - Proxy server IP address
 * @port - Proxy server port
 * @enable - True, if the proxy should be enabled
 * @type - Proxy type
 */
suspend fun TelegramClient.editProxy(
    proxyId: Int = 0,
    server: String? = null,
    port: Int = 0,
    enable: Boolean = false,
    type: ProxyType? = null
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
 * Edits an existing proxy server for network requests
 * Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: EditProxy
): Proxy = exec(f) as Proxy

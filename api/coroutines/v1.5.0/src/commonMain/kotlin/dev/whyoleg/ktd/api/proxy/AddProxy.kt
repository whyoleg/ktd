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
 *
 * @server - Proxy server IP address
 * @port - Proxy server port
 * @enable - True, if the proxy should be enabled
 * @type - Proxy type
 */
suspend fun TelegramClient.addProxy(
    server: String? = null,
    port: Int = 0,
    enable: Boolean = false,
    type: ProxyType? = null
): Proxy = proxy(
    AddProxy(
        server,
        port,
        enable,
        type
    )
)

/**
 * Adds a proxy server for network requests
 * Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: AddProxy
): Proxy = exec(f) as Proxy

@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.test

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sends a simple network request to the Telegram servers via proxy
 * Can be called before authorization
 *
 * @server - Proxy server IP address
 * @port - Proxy server port
 * @type - Proxy type
 * @dcId - Identifier of a datacenter, with which to test connection
 * @timeout - Maximum overall timeout for the request
 */
@TestingOnly
suspend fun TelegramClient.testProxy(
    server: String? = null,
    port: Int = 0,
    type: ProxyType? = null,
    dcId: Int = 0,
    timeout: Double = 0.0
): Ok = test(
    TestProxy(
        server,
        port,
        type,
        dcId,
        timeout
    )
)

/**
 * Sends a simple network request to the Telegram servers via proxy
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestProxy
): Ok = exec(f) as Ok

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
 * Removes a proxy server
 * Can be called before authorization
 *
 * @proxyId - Proxy identifier
 */
suspend fun TelegramClient.removeProxy(
    proxyId: Int = 0
): Ok = proxy(
    RemoveProxy(
        proxyId
    )
)

/**
 * Removes a proxy server
 * Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: RemoveProxy
): Ok = exec(f) as Ok

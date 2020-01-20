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
 * Computes time needed to receive a response from a Telegram server through a proxy
 * Can be called before authorization
 *
 * @proxyId - Proxy identifier
 *            Use 0 to ping a Telegram server without a proxy
 */
suspend fun TelegramClient.pingProxy(
    proxyId: Int = 0
): Seconds = proxy(
    PingProxy(
        proxyId
    )
)

/**
 * Computes time needed to receive a response from a Telegram server through a proxy
 * Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: PingProxy
): Seconds = exec(f) as Seconds

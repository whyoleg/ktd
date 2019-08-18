@file:Suppress("unused")

package dev.whyoleg.ktd.api.seconds

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Computes time needed to receive a response from a Telegram server through a proxy. Can be called before authorization
 *
 * @proxyId - Proxy identifier. Use 0 to ping a Telegram server without a proxy
 */
suspend fun TelegramClient.pingProxy(
    proxyId: Int
): Seconds = seconds(
    PingProxy(
        proxyId
    )
)

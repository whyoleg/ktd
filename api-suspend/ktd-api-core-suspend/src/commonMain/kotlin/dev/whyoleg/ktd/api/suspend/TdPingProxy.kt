package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Computes time needed to receive a response from a Telegram server through a proxy
 * Can be called before authorization
 *
 * @property proxyId Proxy identifier
 *                   Use 0 to ping a Telegram server without a proxy
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.pingProxy(proxyId: Int = 0, extra: TdExtra = TdExtra.EMPTY): TdSeconds =
        exec(TdPingProxy(proxyId, extra))

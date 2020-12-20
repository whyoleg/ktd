package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes a proxy server
 * Can be called before authorization
 *
 * @property proxyId Proxy identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.removeProxy(proxyId: Int = 0, extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdRemoveProxy(proxyId, extra))

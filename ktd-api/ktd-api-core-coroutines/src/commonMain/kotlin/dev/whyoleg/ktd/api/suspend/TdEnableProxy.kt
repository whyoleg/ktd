package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Enables a proxy
 * Only one proxy can be enabled at a time
 * Can be called before authorization
 *
 * @property proxyId Proxy identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.enableProxy(proxyId: Int = 0, extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdEnableProxy(proxyId, extra))

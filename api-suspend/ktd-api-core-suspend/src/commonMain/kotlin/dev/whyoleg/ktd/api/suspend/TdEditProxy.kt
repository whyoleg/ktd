package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Edits an existing proxy server for network requests
 * Can be called before authorization
 *
 * @property proxyId Proxy identifier
 * @property server Proxy server IP address
 * @property port Proxy server port
 * @property enable True, if the proxy should be enabled
 * @property type Proxy type
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.editProxy(
    proxyId: Int = 0,
    server: String? = null,
    port: Int = 0,
    enable: Boolean = false,
    type: TdProxyType? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdProxy = exec(TdEditProxy(proxyId, server, port, enable, type, extra))

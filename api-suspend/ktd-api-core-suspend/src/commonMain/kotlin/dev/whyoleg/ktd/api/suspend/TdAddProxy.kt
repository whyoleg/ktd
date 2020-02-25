package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds a proxy server for network requests
 * Can be called before authorization
 *
 * @property server Proxy server IP address
 * @property port Proxy server port
 * @property enable True, if the proxy should be enabled
 * @property type Proxy type
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.addProxy(
    server: String? = null,
    port: Int = 0,
    enable: Boolean = false,
    type: TdProxyType? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdProxy = exec(TdAddProxy(server, port, enable, type, extra))

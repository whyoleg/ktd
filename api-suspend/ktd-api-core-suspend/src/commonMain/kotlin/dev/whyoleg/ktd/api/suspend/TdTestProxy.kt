package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends a simple network request to the Telegram servers via proxy
 * Can be called before authorization
 *
 * @property server Proxy server IP address
 * @property port Proxy server port
 * @property type Proxy type
 * @property dcId Identifier of a datacenter, with which to test connection
 * @property timeout The maximum overall timeout for the request
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.testProxy(
    server: String? = null,
    port: Int = 0,
    type: TdProxyType? = null,
    dcId: Int = 0,
    timeout: Double = 0.0,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdTestProxy(server, port, type, dcId, timeout, extra))

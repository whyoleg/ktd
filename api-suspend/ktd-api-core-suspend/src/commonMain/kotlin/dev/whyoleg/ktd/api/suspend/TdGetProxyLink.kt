package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns an HTTPS link, which can be used to add a proxy
 * Available only for SOCKS5 and MTProto proxies
 * Can be called before authorization
 *
 * @property proxyId Proxy identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getProxyLink(proxyId: Int = 0, extra: TdExtra = TdExtra.EMPTY): TdText =
        exec(TdGetProxyLink(proxyId, extra))

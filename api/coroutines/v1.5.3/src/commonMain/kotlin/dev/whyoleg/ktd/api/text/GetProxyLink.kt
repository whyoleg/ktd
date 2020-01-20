@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.text

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns an HTTPS link, which can be used to add a proxy
 * Available only for SOCKS5 and MTProto proxies
 * Can be called before authorization
 *
 * @proxyId - Proxy identifier
 */
suspend fun TelegramClient.getProxyLink(
    proxyId: Int = 0
): Text = text(
    GetProxyLink(
        proxyId
    )
)

/**
 * Returns an HTTPS link, which can be used to add a proxy
 * Available only for SOCKS5 and MTProto proxies
 * Can be called before authorization
 */
suspend fun TelegramClient.text(
    f: GetProxyLink
): Text = exec(f) as Text

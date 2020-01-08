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
 * Enables a proxy
 * Only one proxy can be enabled at a time
 * Can be called before authorization
 *
 * @proxyId - Proxy identifier
 */
suspend fun TelegramClient.enableProxy(
    proxyId: Int = 0
): Ok = proxy(
    EnableProxy(
        proxyId
    )
)

/**
 * Enables a proxy
 * Only one proxy can be enabled at a time
 * Can be called before authorization
 */
suspend fun TelegramClient.proxy(
    f: EnableProxy
): Ok = exec(f) as Ok

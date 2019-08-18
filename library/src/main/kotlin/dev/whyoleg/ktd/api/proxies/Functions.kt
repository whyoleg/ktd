@file:Suppress("unused")

package dev.whyoleg.ktd.api.proxies

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns list of proxies that are currently set up. Can be called before authorization
 */
suspend fun TelegramClient.proxies(
    f: GetProxies
): Proxies = execRaw(f) as Proxies

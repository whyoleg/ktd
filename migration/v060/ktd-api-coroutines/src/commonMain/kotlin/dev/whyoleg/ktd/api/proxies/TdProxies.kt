@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.proxies

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.proxies(f: TdGetProxies): TdProxies = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getProxies()", "dev.whyoleg.ktd.api.suspend.getProxies"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getProxies(): TdProxies = exec(TdGetProxies())

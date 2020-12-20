@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.connected

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.connected(f: TdGetConnectedWebsites): TdConnectedWebsites = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getConnectedWebsites()",
            "dev.whyoleg.ktd.api.suspend.getConnectedWebsites"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getConnectedWebsites(): TdConnectedWebsites =
        exec(TdGetConnectedWebsites())

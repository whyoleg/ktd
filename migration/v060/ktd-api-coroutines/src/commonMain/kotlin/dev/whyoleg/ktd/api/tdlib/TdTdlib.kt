@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.tdlib

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.tdlib(f: TdSetTdlibParameters): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setTdlibParameters(parameters)",
            "dev.whyoleg.ktd.api.suspend.setTdlibParameters"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setTdlibParameters(parameters: TdTdlibParameters? = null): TdOk =
        exec(TdSetTdlibParameters(parameters))

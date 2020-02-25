@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.option

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.option(f: TdGetOption): TdOptionValue = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getOption(name)", "dev.whyoleg.ktd.api.suspend.getOption"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getOption(name: String? = null): TdOptionValue = exec(TdGetOption(name))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.option(f: TdSetOption): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setOption(name, value)", "dev.whyoleg.ktd.api.suspend.setOption"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setOption(name: String? = null, value: TdOptionValue? = null): TdOk =
        exec(TdSetOption(name, value))

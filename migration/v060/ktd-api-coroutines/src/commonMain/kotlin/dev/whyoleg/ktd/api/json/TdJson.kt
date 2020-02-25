@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.json

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.json(f: TdGetJsonValue): TdJsonValue = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getJsonValue(json)", "dev.whyoleg.ktd.api.suspend.getJsonValue"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getJsonValue(json: String? = null): TdJsonValue =
        exec(TdGetJsonValue(json))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.json(f: TdGetApplicationConfig): TdJsonValue = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getApplicationConfig()",
            "dev.whyoleg.ktd.api.suspend.getApplicationConfig"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getApplicationConfig(): TdJsonValue = exec(TdGetApplicationConfig())

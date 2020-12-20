@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.order

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.order(f: TdGetSavedOrderInfo): TdOrderInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getSavedOrderInfo()",
            "dev.whyoleg.ktd.api.suspend.getSavedOrderInfo"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getSavedOrderInfo(): TdOrderInfo = exec(TdGetSavedOrderInfo())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.order(f: TdDeleteSavedOrderInfo): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("deleteSavedOrderInfo()",
            "dev.whyoleg.ktd.api.suspend.deleteSavedOrderInfo"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.deleteSavedOrderInfo(): TdOk = exec(TdDeleteSavedOrderInfo())

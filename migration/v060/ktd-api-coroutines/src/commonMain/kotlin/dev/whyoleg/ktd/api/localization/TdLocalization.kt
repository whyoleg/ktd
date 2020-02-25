@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.localization

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.localization(f: TdGetLocalizationTargetInfo): TdLocalizationTargetInfo =
        exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getLocalizationTargetInfo(onlyLocal)",
            "dev.whyoleg.ktd.api.suspend.getLocalizationTargetInfo"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getLocalizationTargetInfo(onlyLocal: Boolean = false):
        TdLocalizationTargetInfo = exec(TdGetLocalizationTargetInfo(onlyLocal))

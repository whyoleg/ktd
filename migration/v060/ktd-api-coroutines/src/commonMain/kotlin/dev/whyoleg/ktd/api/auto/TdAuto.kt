@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.auto

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.auto(f: TdGetAutoDownloadSettingsPresets): TdAutoDownloadSettingsPresets
        = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getAutoDownloadSettingsPresets()",
            "dev.whyoleg.ktd.api.suspend.getAutoDownloadSettingsPresets"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getAutoDownloadSettingsPresets(): TdAutoDownloadSettingsPresets =
        exec(TdGetAutoDownloadSettingsPresets())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.auto(f: TdSetAutoDownloadSettings): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setAutoDownloadSettings(settings, type)",
            "dev.whyoleg.ktd.api.suspend.setAutoDownloadSettings"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setAutoDownloadSettings(settings: TdAutoDownloadSettings? = null,
        type: TdNetworkType? = null): TdOk = exec(TdSetAutoDownloadSettings(settings, type))

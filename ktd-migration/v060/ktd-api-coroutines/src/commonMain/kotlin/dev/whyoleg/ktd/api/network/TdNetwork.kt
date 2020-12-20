@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.network

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.network(f: TdSetNetworkType): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setNetworkType(type)", "dev.whyoleg.ktd.api.suspend.setNetworkType"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setNetworkType(type: TdNetworkType? = null): TdOk =
        exec(TdSetNetworkType(type))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.network(f: TdGetNetworkStatistics): TdNetworkStatistics = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getNetworkStatistics(onlyCurrent)",
            "dev.whyoleg.ktd.api.suspend.getNetworkStatistics"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getNetworkStatistics(onlyCurrent: Boolean = false): TdNetworkStatistics =
        exec(TdGetNetworkStatistics(onlyCurrent))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.network(f: TdAddNetworkStatistics): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("addNetworkStatistics(entry)",
            "dev.whyoleg.ktd.api.suspend.addNetworkStatistics"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.addNetworkStatistics(entry: TdNetworkStatisticsEntry? = null): TdOk =
        exec(TdAddNetworkStatistics(entry))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.network(f: TdResetNetworkStatistics): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("resetNetworkStatistics()",
            "dev.whyoleg.ktd.api.suspend.resetNetworkStatistics"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.resetNetworkStatistics(): TdOk = exec(TdResetNetworkStatistics())

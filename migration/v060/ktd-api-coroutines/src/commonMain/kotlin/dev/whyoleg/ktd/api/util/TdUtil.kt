@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.util

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.util(f: TdClose): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("close()", "dev.whyoleg.ktd.api.suspend.close"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.close(): TdOk = exec(TdClose())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.util(f: TdDestroy): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("destroy()", "dev.whyoleg.ktd.api.suspend.destroy"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.destroy(): TdOk = exec(TdDestroy())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.util(f: TdGetRecentlyVisitedTMeUrls): TdTMeUrls = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getRecentlyVisitedTMeUrls(referrer)",
            "dev.whyoleg.ktd.api.suspend.getRecentlyVisitedTMeUrls"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getRecentlyVisitedTMeUrls(referrer: String? = null): TdTMeUrls =
        exec(TdGetRecentlyVisitedTMeUrls(referrer))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.util(f: TdSetAlarm): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setAlarm(seconds)", "dev.whyoleg.ktd.api.suspend.setAlarm"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setAlarm(seconds: Double = 0.0): TdOk = exec(TdSetAlarm(seconds))

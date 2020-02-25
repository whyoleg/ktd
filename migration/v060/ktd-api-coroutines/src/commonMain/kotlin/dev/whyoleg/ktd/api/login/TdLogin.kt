@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.login

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.login(f: TdGetLoginUrlInfo): TdLoginUrlInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getLoginUrlInfo(chatId, messageId, buttonId)",
            "dev.whyoleg.ktd.api.suspend.getLoginUrlInfo"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getLoginUrlInfo(
    chatId: Long = 0L,
    messageId: Long = 0L,
    buttonId: Int = 0
): TdLoginUrlInfo = exec(TdGetLoginUrlInfo(chatId, messageId, buttonId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.login(f: TdGetLoginUrl): TdHttpUrl = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getLoginUrl(chatId, messageId, buttonId, allowWriteAccess)",
            "dev.whyoleg.ktd.api.suspend.getLoginUrl"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getLoginUrl(
    chatId: Long = 0L,
    messageId: Long = 0L,
    buttonId: Int = 0,
    allowWriteAccess: Boolean = false
): TdHttpUrl = exec(TdGetLoginUrl(chatId, messageId, buttonId, allowWriteAccess))

@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.account

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.account(f: TdSetAccountTtl): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setAccountTtl(ttl)", "dev.whyoleg.ktd.api.suspend.setAccountTtl"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setAccountTtl(ttl: TdAccountTtl? = null): TdOk =
        exec(TdSetAccountTtl(ttl))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.account(f: TdGetAccountTtl): TdAccountTtl = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getAccountTtl()", "dev.whyoleg.ktd.api.suspend.getAccountTtl"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getAccountTtl(): TdAccountTtl = exec(TdGetAccountTtl())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.account(f: TdDeleteAccount): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("deleteAccount(reason)", "dev.whyoleg.ktd.api.suspend.deleteAccount"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.deleteAccount(reason: String? = null): TdOk =
        exec(TdDeleteAccount(reason))

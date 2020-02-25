@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.session

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.session(f: TdConfirmQrCodeAuthentication): TdSession = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("confirmQrCodeAuthentication(link)",
            "dev.whyoleg.ktd.api.suspend.confirmQrCodeAuthentication"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.confirmQrCodeAuthentication(link: String? = null): TdSession =
        exec(TdConfirmQrCodeAuthentication(link))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.session(f: TdGetActiveSessions): TdSessions = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getActiveSessions()",
            "dev.whyoleg.ktd.api.suspend.getActiveSessions"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getActiveSessions(): TdSessions = exec(TdGetActiveSessions())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.session(f: TdTerminateSession): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("terminateSession(sessionId)",
            "dev.whyoleg.ktd.api.suspend.terminateSession"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.terminateSession(sessionId: Long = 0L): TdOk =
        exec(TdTerminateSession(sessionId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.session(f: TdTerminateAllOtherSessions): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("terminateAllOtherSessions()",
            "dev.whyoleg.ktd.api.suspend.terminateAllOtherSessions"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.terminateAllOtherSessions(): TdOk = exec(TdTerminateAllOtherSessions())

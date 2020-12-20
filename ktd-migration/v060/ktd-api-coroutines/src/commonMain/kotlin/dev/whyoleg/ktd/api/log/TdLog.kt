@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.log

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.log(f: TdLogOut): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("logOut()", "dev.whyoleg.ktd.api.suspend.logOut"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.logOut(): TdOk = exec(TdLogOut())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.log(f: TdSaveApplicationLogEvent): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("saveApplicationLogEvent(type, chatId, data)",
            "dev.whyoleg.ktd.api.suspend.saveApplicationLogEvent"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.saveApplicationLogEvent(
    type: String? = null,
    chatId: Long = 0L,
    data: TdJsonValue? = null
): TdOk = exec(TdSaveApplicationLogEvent(type, chatId, data))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.log(f: TdSetLogStream): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setLogStream(logStream)",
            "dev.whyoleg.ktd.api.suspend.setLogStream"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setLogStream(logStream: TdLogStream? = null): TdOk =
        exec(TdSetLogStream(logStream))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.log(f: TdGetLogStream): TdLogStream = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getLogStream()", "dev.whyoleg.ktd.api.suspend.getLogStream"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getLogStream(): TdLogStream = exec(TdGetLogStream())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.log(f: TdSetLogVerbosityLevel): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setLogVerbosityLevel(newVerbosityLevel)",
            "dev.whyoleg.ktd.api.suspend.setLogVerbosityLevel"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setLogVerbosityLevel(newVerbosityLevel: Int = 0): TdOk =
        exec(TdSetLogVerbosityLevel(newVerbosityLevel))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.log(f: TdGetLogVerbosityLevel): TdLogVerbosityLevel = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getLogVerbosityLevel()",
            "dev.whyoleg.ktd.api.suspend.getLogVerbosityLevel"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getLogVerbosityLevel(): TdLogVerbosityLevel =
        exec(TdGetLogVerbosityLevel())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.log(f: TdGetLogTags): TdLogTags = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getLogTags()", "dev.whyoleg.ktd.api.suspend.getLogTags"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getLogTags(): TdLogTags = exec(TdGetLogTags())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.log(f: TdSetLogTagVerbosityLevel): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setLogTagVerbosityLevel(tag, newVerbosityLevel)",
            "dev.whyoleg.ktd.api.suspend.setLogTagVerbosityLevel"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setLogTagVerbosityLevel(tag: String? = null, newVerbosityLevel: Int = 0):
        TdOk = exec(TdSetLogTagVerbosityLevel(tag, newVerbosityLevel))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.log(f: TdGetLogTagVerbosityLevel): TdLogVerbosityLevel = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getLogTagVerbosityLevel(tag)",
            "dev.whyoleg.ktd.api.suspend.getLogTagVerbosityLevel"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getLogTagVerbosityLevel(tag: String? = null): TdLogVerbosityLevel =
        exec(TdGetLogTagVerbosityLevel(tag))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.log(f: TdAddLogMessage): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("addLogMessage(verbosityLevel, text)",
            "dev.whyoleg.ktd.api.suspend.addLogMessage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.addLogMessage(verbosityLevel: Int = 0, text: String? = null): TdOk =
        exec(TdAddLogMessage(verbosityLevel, text))

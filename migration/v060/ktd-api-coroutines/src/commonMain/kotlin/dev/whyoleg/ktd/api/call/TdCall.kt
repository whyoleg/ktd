@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.call

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.call(f: TdCreateCall): TdCallId = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("createCall(userId, protocol)",
            "dev.whyoleg.ktd.api.suspend.createCall"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.createCall(userId: Int = 0, protocol: TdCallProtocol? = null): TdCallId =
        exec(TdCreateCall(userId, protocol))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.call(f: TdAcceptCall): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("acceptCall(callId, protocol)",
            "dev.whyoleg.ktd.api.suspend.acceptCall"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.acceptCall(callId: Int = 0, protocol: TdCallProtocol? = null): TdOk =
        exec(TdAcceptCall(callId, protocol))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.call(f: TdDiscardCall): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("discardCall(callId, isDisconnected, duration, connectionId)",
            "dev.whyoleg.ktd.api.suspend.discardCall"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.discardCall(
    callId: Int = 0,
    isDisconnected: Boolean = false,
    duration: Int = 0,
    connectionId: Long = 0L
): TdOk = exec(TdDiscardCall(callId, isDisconnected, duration, connectionId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.call(f: TdSendCallRating): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("sendCallRating(callId, rating, comment, problems)",
            "dev.whyoleg.ktd.api.suspend.sendCallRating"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendCallRating(
    callId: Int = 0,
    rating: Int = 0,
    comment: String? = null,
    problems: List<TdCallProblem> = emptyList()
): TdOk = exec(TdSendCallRating(callId, rating, comment, problems))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.call(f: TdSendCallDebugInformation): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("sendCallDebugInformation(callId, debugInformation)",
            "dev.whyoleg.ktd.api.suspend.sendCallDebugInformation"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendCallDebugInformation(callId: Int = 0, debugInformation: String? =
        null): TdOk = exec(TdSendCallDebugInformation(callId, debugInformation))

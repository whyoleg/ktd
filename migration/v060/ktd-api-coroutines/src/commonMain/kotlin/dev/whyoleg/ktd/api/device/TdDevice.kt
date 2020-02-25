@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.device

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.device(f: TdRegisterDevice): TdPushReceiverId = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("registerDevice(deviceToken, otherUserIds)",
            "dev.whyoleg.ktd.api.suspend.registerDevice"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.registerDevice(deviceToken: TdDeviceToken? = null, otherUserIds: IntArray
        = intArrayOf()): TdPushReceiverId = exec(TdRegisterDevice(deviceToken, otherUserIds))

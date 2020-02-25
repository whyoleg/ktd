@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.validated

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.validated(f: TdValidateOrderInfo): TdValidatedOrderInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("validateOrderInfo(chatId, messageId, orderInfo, allowSave)",
            "dev.whyoleg.ktd.api.suspend.validateOrderInfo"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.validateOrderInfo(
    chatId: Long = 0L,
    messageId: Long = 0L,
    orderInfo: TdOrderInfo? = null,
    allowSave: Boolean = false
): TdValidatedOrderInfo = exec(TdValidateOrderInfo(chatId, messageId, orderInfo, allowSave))

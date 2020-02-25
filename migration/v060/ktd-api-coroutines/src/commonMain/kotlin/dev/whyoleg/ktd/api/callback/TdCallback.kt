@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.callback

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.callback(f: TdGetCallbackQueryAnswer): TdCallbackQueryAnswer = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getCallbackQueryAnswer(chatId, messageId, payload)",
            "dev.whyoleg.ktd.api.suspend.getCallbackQueryAnswer"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getCallbackQueryAnswer(
    chatId: Long = 0L,
    messageId: Long = 0L,
    payload: TdCallbackQueryPayload? = null
): TdCallbackQueryAnswer = exec(TdGetCallbackQueryAnswer(chatId, messageId, payload))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.callback(f: TdAnswerCallbackQuery): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("answerCallbackQuery(callbackQueryId, text, showAlert, url, cacheTime)",
            "dev.whyoleg.ktd.api.suspend.answerCallbackQuery"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.answerCallbackQuery(
    callbackQueryId: Long = 0L,
    text: String? = null,
    showAlert: Boolean = false,
    url: String? = null,
    cacheTime: Int = 0
): TdOk = exec(TdAnswerCallbackQuery(callbackQueryId, text, showAlert, url, cacheTime))

@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.poll

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.poll(f: TdSetPollAnswer): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setPollAnswer(chatId, messageId, optionIds)",
            "dev.whyoleg.ktd.api.suspend.setPollAnswer"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setPollAnswer(
    chatId: Long = 0L,
    messageId: Long = 0L,
    optionIds: IntArray = intArrayOf()
): TdOk = exec(TdSetPollAnswer(chatId, messageId, optionIds))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.poll(f: TdStopPoll): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("stopPoll(chatId, messageId, replyMarkup)",
            "dev.whyoleg.ktd.api.suspend.stopPoll"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.stopPoll(
    chatId: Long = 0L,
    messageId: Long = 0L,
    replyMarkup: TdReplyMarkup? = null
): TdOk = exec(TdStopPoll(chatId, messageId, replyMarkup))

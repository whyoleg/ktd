@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.chat

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Reports to the server whether a chat is a spam chat or not
 * Can be used only if ChatReportSpamState.can_report_spam is true
 * After this request, ChatReportSpamState.can_report_spam becomes false forever
 *
 * @chatId - Chat identifier
 * @isSpamChat - If true, the chat will be reported as spam
 *               Otherwise it will be marked as not spam
 */
suspend fun TelegramClient.changeChatReportSpamState(
    chatId: Long = 0L,
    isSpamChat: Boolean = false
): Ok = chat(
    ChangeChatReportSpamState(
        chatId,
        isSpamChat
    )
)

/**
 * Reports to the server whether a chat is a spam chat or not
 * Can be used only if ChatReportSpamState.can_report_spam is true
 * After this request, ChatReportSpamState.can_report_spam becomes false forever
 */
suspend fun TelegramClient.chat(
    f: ChangeChatReportSpamState
): Ok = exec(f) as Ok

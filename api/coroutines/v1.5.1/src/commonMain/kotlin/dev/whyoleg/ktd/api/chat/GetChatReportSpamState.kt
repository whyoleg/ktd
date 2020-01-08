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
 * Returns information on whether the current chat can be reported as spam
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.getChatReportSpamState(
    chatId: Long = 0L
): ChatReportSpamState = chat(
    GetChatReportSpamState(
        chatId
    )
)

/**
 * Returns information on whether the current chat can be reported as spam
 */
suspend fun TelegramClient.chat(
    f: GetChatReportSpamState
): ChatReportSpamState = exec(f) as ChatReportSpamState

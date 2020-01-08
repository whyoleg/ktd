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
 * Reports a chat to the Telegram moderators
 * Supported only for supergroups, channels, or private chats with bots, since other chats can't be checked by moderators, or when the report is done from the chat action bar
 *
 * @chatId - Chat identifier
 * @reason - The reason for reporting the chat
 * @messageIds - Identifiers of reported messages, if any
 */
suspend fun TelegramClient.reportChat(
    chatId: Long = 0L,
    reason: ChatReportReason? = null,
    messageIds: LongArray = longArrayOf()
): Ok = chat(
    ReportChat(
        chatId,
        reason,
        messageIds
    )
)

/**
 * Reports a chat to the Telegram moderators
 * Supported only for supergroups, channels, or private chats with bots, since other chats can't be checked by moderators, or when the report is done from the chat action bar
 */
suspend fun TelegramClient.chat(
    f: ReportChat
): Ok = exec(f) as Ok

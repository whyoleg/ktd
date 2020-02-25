package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Reports a chat to the Telegram moderators
 * Supported only for supergroups, channels, or private chats with bots, since other chats can't be checked by moderators, or when the report is done from the chat action bar
 *
 * @property chatId Chat identifier
 * @property reason The reason for reporting the chat
 * @property messageIds Identifiers of reported messages, if any
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.reportChat(
    chatId: Long = 0L,
    reason: TdChatReportReason? = null,
    messageIds: LongArray = longArrayOf(),
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdReportChat(chatId, reason, messageIds, extra))

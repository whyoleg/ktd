package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the marked as unread state of a chat
 *
 * @property chatId Chat identifier
 * @property isMarkedAsUnread New value of is_marked_as_unread
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.toggleChatIsMarkedAsUnread(
    chatId: Long = 0L,
    isMarkedAsUnread: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdToggleChatIsMarkedAsUnread(chatId, isMarkedAsUnread, extra))

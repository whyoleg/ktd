package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the pinned state of a chat
 * You can pin up to GetOption("pinned_chat_count_max")/GetOption("pinned_archived_chat_count_max") non-secret chats and the same number of secret chats in the main/archive chat list
 *
 * @property chatId Chat identifier
 * @property isPinned New value of is_pinned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.toggleChatIsPinned(
    chatId: Long = 0L,
    isPinned: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdToggleChatIsPinned(chatId, isPinned, extra))

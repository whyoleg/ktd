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
 * Changes the pinned state of a chat
 * You can pin up to GetOption("pinned_chat_count_max") non-secret chats and the same number of secret chats
 *
 * @chatId - Chat identifier
 * @isPinned - New value of is_pinned
 */
suspend fun TelegramClient.toggleChatIsPinned(
    chatId: Long = 0L,
    isPinned: Boolean = false
): Ok = chat(
    ToggleChatIsPinned(
        chatId,
        isPinned
    )
)

/**
 * Changes the pinned state of a chat
 * You can pin up to GetOption("pinned_chat_count_max") non-secret chats and the same number of secret chats
 */
suspend fun TelegramClient.chat(
    f: ToggleChatIsPinned
): Ok = exec(f) as Ok

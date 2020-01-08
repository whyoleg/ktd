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
 * Changes the marked as unread state of a chat
 *
 * @chatId - Chat identifier
 * @isMarkedAsUnread - New value of is_marked_as_unread
 */
suspend fun TelegramClient.toggleChatIsMarkedAsUnread(
    chatId: Long = 0L,
    isMarkedAsUnread: Boolean = false
): Ok = chat(
    ToggleChatIsMarkedAsUnread(
        chatId,
        isMarkedAsUnread
    )
)

/**
 * Changes the marked as unread state of a chat
 */
suspend fun TelegramClient.chat(
    f: ToggleChatIsMarkedAsUnread
): Ok = exec(f) as Ok

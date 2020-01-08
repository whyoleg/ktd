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
 * Deletes all messages sent by the specified user to a chat
 * Supported only for supergroups
 * Requires can_delete_messages administrator privileges
 *
 * @chatId - Chat identifier
 * @userId - User identifier
 */
suspend fun TelegramClient.deleteChatMessagesFromUser(
    chatId: Long = 0L,
    userId: Int = 0
): Ok = chat(
    DeleteChatMessagesFromUser(
        chatId,
        userId
    )
)

/**
 * Deletes all messages sent by the specified user to a chat
 * Supported only for supergroups
 * Requires can_delete_messages administrator privileges
 */
suspend fun TelegramClient.chat(
    f: DeleteChatMessagesFromUser
): Ok = exec(f) as Ok

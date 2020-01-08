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
 * Adds a new member to a chat
 * Members can't be added to private or secret chats
 * Members will not be added until the chat state has been synchronized with the server
 *
 * @chatId - Chat identifier
 * @userId - Identifier of the user
 * @forwardLimit - The number of earlier messages from the chat to be forwarded to the new member
 *                 Ignored for supergroups and channels
 */
suspend fun TelegramClient.addChatMember(
    chatId: Long = 0L,
    userId: Int = 0,
    forwardLimit: Int = 0
): Ok = chat(
    AddChatMember(
        chatId,
        userId,
        forwardLimit
    )
)

/**
 * Adds a new member to a chat
 * Members can't be added to private or secret chats
 * Members will not be added until the chat state has been synchronized with the server
 */
suspend fun TelegramClient.chat(
    f: AddChatMember
): Ok = exec(f) as Ok

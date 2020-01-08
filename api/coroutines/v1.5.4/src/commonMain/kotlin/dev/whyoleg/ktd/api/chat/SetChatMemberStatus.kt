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
 * Changes the status of a chat member, needs appropriate privileges
 * This function is currently not suitable for adding new members to the chat and transferring chat ownership
 * Instead, use addChatMember or transferChatOwnership
 * The chat member status will not be changed until it has been synchronized with the server
 *
 * @chatId - Chat identifier
 * @userId - User identifier
 * @status - The new status of the member in the chat
 */
suspend fun TelegramClient.setChatMemberStatus(
    chatId: Long = 0L,
    userId: Int = 0,
    status: ChatMemberStatus? = null
): Ok = chat(
    SetChatMemberStatus(
        chatId,
        userId,
        status
    )
)

/**
 * Changes the status of a chat member, needs appropriate privileges
 * This function is currently not suitable for adding new members to the chat and transferring chat ownership
 * Instead, use addChatMember or transferChatOwnership
 * The chat member status will not be changed until it has been synchronized with the server
 */
suspend fun TelegramClient.chat(
    f: SetChatMemberStatus
): Ok = exec(f) as Ok

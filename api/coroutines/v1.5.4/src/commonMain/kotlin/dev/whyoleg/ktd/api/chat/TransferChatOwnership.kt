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
 * Changes the owner of a chat
 * The current user must be a current owner of the chat
 * Use the method canTransferOwnership to check whether the ownership can be transferred from the current session
 * Available only for supergroups and channel chats
 *
 * @chatId - Chat identifier
 * @userId - Identifier of the user to which transfer the ownership
 *           The ownership can't be transferred to a bot or to a deleted user
 * @password - The password of the current user
 */
suspend fun TelegramClient.transferChatOwnership(
    chatId: Long = 0L,
    userId: Int = 0,
    password: String? = null
): Ok = chat(
    TransferChatOwnership(
        chatId,
        userId,
        password
    )
)

/**
 * Changes the owner of a chat
 * The current user must be a current owner of the chat
 * Use the method canTransferOwnership to check whether the ownership can be transferred from the current session
 * Available only for supergroups and channel chats
 */
suspend fun TelegramClient.chat(
    f: TransferChatOwnership
): Ok = exec(f) as Ok

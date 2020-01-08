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
 * Adds current user as a new member to a chat
 * Private and secret chats can't be joined using this method
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.joinChat(
    chatId: Long = 0L
): Ok = chat(
    JoinChat(
        chatId
    )
)

/**
 * Adds current user as a new member to a chat
 * Private and secret chats can't be joined using this method
 */
suspend fun TelegramClient.chat(
    f: JoinChat
): Ok = exec(f) as Ok

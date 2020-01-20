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
 * Moves a chat to a different chat list
 *
 * @chatId - Chat identifier
 * @chatList - New chat list of the chat
 */
suspend fun TelegramClient.setChatChatList(
    chatId: Long = 0L,
    chatList: ChatList? = null
): Ok = chat(
    SetChatChatList(
        chatId,
        chatList
    )
)

/**
 * Moves a chat to a different chat list
 */
suspend fun TelegramClient.chat(
    f: SetChatChatList
): Ok = exec(f) as Ok

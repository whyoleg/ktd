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
 * Returns an ordered list of chats in a chat list
 * Chats are sorted by the pair (order, chat_id) in decreasing order
 * (For example, to get a list of chats from the beginning, the offset_order should be equal to a biggest signed 64-bit number 9223372036854775807 == 2^63 - 1)
 * For optimal performance the number of returned chats is chosen by the library
 *
 * @chatList - The chat list in which to return chats
 * @offsetOrder - Chat order to return chats from
 * @offsetChatId - Chat identifier to return chats from
 * @limit - The maximum number of chats to be returned
 *          It is possible that fewer chats than the limit are returned even if the end of the list is not reached
 */
suspend fun TelegramClient.getChats(
    chatList: ChatList? = null,
    offsetOrder: Long = 0L,
    offsetChatId: Long = 0L,
    limit: Int = 0
): Chats = chat(
    GetChats(
        chatList,
        offsetOrder,
        offsetChatId,
        limit
    )
)

/**
 * Returns an ordered list of chats in a chat list
 * Chats are sorted by the pair (order, chat_id) in decreasing order
 * (For example, to get a list of chats from the beginning, the offset_order should be equal to a biggest signed 64-bit number 9223372036854775807 == 2^63 - 1)
 * For optimal performance the number of returned chats is chosen by the library
 */
suspend fun TelegramClient.chat(
    f: GetChats
): Chats = exec(f) as Chats

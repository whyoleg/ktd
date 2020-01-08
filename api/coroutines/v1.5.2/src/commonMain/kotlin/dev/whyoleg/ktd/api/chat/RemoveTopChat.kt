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
 * Removes a chat from the list of frequently used chats
 * Supported only if the chat info database is enabled
 *
 * @category - Category of frequently used chats
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.removeTopChat(
    category: TopChatCategory? = null,
    chatId: Long = 0L
): Ok = chat(
    RemoveTopChat(
        category,
        chatId
    )
)

/**
 * Removes a chat from the list of frequently used chats
 * Supported only if the chat info database is enabled
 */
suspend fun TelegramClient.chat(
    f: RemoveTopChat
): Ok = exec(f) as Ok

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
 * Adds a chat to the list of recently found chats
 * The chat is added to the beginning of the list
 * If the chat is already in the list, it will be removed from the list first
 *
 * @chatId - Identifier of the chat to add
 */
suspend fun TelegramClient.addRecentlyFoundChat(
    chatId: Long = 0L
): Ok = chat(
    AddRecentlyFoundChat(
        chatId
    )
)

/**
 * Adds a chat to the list of recently found chats
 * The chat is added to the beginning of the list
 * If the chat is already in the list, it will be removed from the list first
 */
suspend fun TelegramClient.chat(
    f: AddRecentlyFoundChat
): Ok = exec(f) as Ok

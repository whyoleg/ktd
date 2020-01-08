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
 * Removes a chat from the list of recently found chats
 *
 * @chatId - Identifier of the chat to be removed
 */
suspend fun TelegramClient.removeRecentlyFoundChat(
    chatId: Long = 0L
): Ok = chat(
    RemoveRecentlyFoundChat(
        chatId
    )
)

/**
 * Removes a chat from the list of recently found chats
 */
suspend fun TelegramClient.chat(
    f: RemoveRecentlyFoundChat
): Ok = exec(f) as Ok

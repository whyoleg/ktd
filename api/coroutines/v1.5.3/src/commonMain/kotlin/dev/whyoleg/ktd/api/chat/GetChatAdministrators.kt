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
 * Returns a list of administrators of the chat with their custom titles
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.getChatAdministrators(
    chatId: Long = 0L
): ChatAdministrators = chat(
    GetChatAdministrators(
        chatId
    )
)

/**
 * Returns a list of administrators of the chat with their custom titles
 */
suspend fun TelegramClient.chat(
    f: GetChatAdministrators
): ChatAdministrators = exec(f) as ChatAdministrators

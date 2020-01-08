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
 * Returns information about a chat by its identifier, this is an offline request if the current user is not a bot
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.getChat(
    chatId: Long = 0L
): Chat = chat(
    GetChat(
        chatId
    )
)

/**
 * Returns information about a chat by its identifier, this is an offline request if the current user is not a bot
 */
suspend fun TelegramClient.chat(
    f: GetChat
): Chat = exec(f) as Chat

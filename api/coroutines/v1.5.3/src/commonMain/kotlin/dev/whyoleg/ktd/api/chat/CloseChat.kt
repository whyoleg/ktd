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
 * Informs TDLib that the chat is closed by the user
 * Many useful activities depend on the chat being opened or closed
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.closeChat(
    chatId: Long = 0L
): Ok = chat(
    CloseChat(
        chatId
    )
)

/**
 * Informs TDLib that the chat is closed by the user
 * Many useful activities depend on the chat being opened or closed
 */
suspend fun TelegramClient.chat(
    f: CloseChat
): Ok = exec(f) as Ok

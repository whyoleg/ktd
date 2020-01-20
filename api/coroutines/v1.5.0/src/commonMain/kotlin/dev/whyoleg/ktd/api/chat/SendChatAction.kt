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
 * Sends a notification about user activity in a chat
 *
 * @chatId - Chat identifier
 * @action - The action description
 */
suspend fun TelegramClient.sendChatAction(
    chatId: Long = 0L,
    action: ChatAction? = null
): Ok = chat(
    SendChatAction(
        chatId,
        action
    )
)

/**
 * Sends a notification about user activity in a chat
 */
suspend fun TelegramClient.chat(
    f: SendChatAction
): Ok = exec(f) as Ok

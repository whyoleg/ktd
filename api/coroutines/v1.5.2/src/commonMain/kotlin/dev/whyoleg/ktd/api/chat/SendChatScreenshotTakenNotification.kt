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
 * Sends a notification about a screenshot taken in a chat
 * Supported only in private and secret chats
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.sendChatScreenshotTakenNotification(
    chatId: Long = 0L
): Ok = chat(
    SendChatScreenshotTakenNotification(
        chatId
    )
)

/**
 * Sends a notification about a screenshot taken in a chat
 * Supported only in private and secret chats
 */
suspend fun TelegramClient.chat(
    f: SendChatScreenshotTakenNotification
): Ok = exec(f) as Ok

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
 * Removes current user from chat members
 * Private and secret chats can't be left using this method
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.leaveChat(
    chatId: Long = 0L
): Ok = chat(
    LeaveChat(
        chatId
    )
)

/**
 * Removes current user from chat members
 * Private and secret chats can't be left using this method
 */
suspend fun TelegramClient.chat(
    f: LeaveChat
): Ok = exec(f) as Ok

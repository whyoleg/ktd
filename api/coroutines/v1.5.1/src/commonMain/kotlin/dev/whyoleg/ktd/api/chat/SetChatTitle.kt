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
 * Changes the chat title
 * Supported only for basic groups, supergroups and channels
 * Requires can_change_info rights
 * The title will not be changed until the request to the server has been completed
 *
 * @chatId - Chat identifier
 * @title - New title of the chat
 */
suspend fun TelegramClient.setChatTitle(
    chatId: Long = 0L,
    title: String? = null
): Ok = chat(
    SetChatTitle(
        chatId,
        title
    )
)

/**
 * Changes the chat title
 * Supported only for basic groups, supergroups and channels
 * Requires can_change_info rights
 * The title will not be changed until the request to the server has been completed
 */
suspend fun TelegramClient.chat(
    f: SetChatTitle
): Ok = exec(f) as Ok

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
 * Changes information about a chat
 * Available for basic groups, supergroups, and channels
 * Requires can_change_info rights
 *
 * @chatId - Identifier of the chat
 * @description - New chat description
 */
suspend fun TelegramClient.setChatDescription(
    chatId: Long = 0L,
    description: String? = null
): Ok = chat(
    SetChatDescription(
        chatId,
        description
    )
)

/**
 * Changes information about a chat
 * Available for basic groups, supergroups, and channels
 * Requires can_change_info rights
 */
suspend fun TelegramClient.chat(
    f: SetChatDescription
): Ok = exec(f) as Ok

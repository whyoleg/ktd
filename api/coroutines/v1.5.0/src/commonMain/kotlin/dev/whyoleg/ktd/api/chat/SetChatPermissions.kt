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
 * Changes the chat members permissions
 * Supported only for basic groups and supergroups
 * Requires can_restrict_members administrator right
 *
 * @chatId - Chat identifier
 * @permissions - New non-administrator members permissions in the chat
 */
suspend fun TelegramClient.setChatPermissions(
    chatId: Long = 0L,
    permissions: ChatPermissions? = null
): Ok = chat(
    SetChatPermissions(
        chatId,
        permissions
    )
)

/**
 * Changes the chat members permissions
 * Supported only for basic groups and supergroups
 * Requires can_restrict_members administrator right
 */
suspend fun TelegramClient.chat(
    f: SetChatPermissions
): Ok = exec(f) as Ok

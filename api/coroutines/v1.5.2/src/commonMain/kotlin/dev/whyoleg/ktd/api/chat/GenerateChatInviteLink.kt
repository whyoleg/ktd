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
 * Generates a new invite link for a chat
 * The previously generated link is revoked
 * Available for basic groups, supergroups, and channels
 * Requires administrator privileges and can_invite_users right
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.generateChatInviteLink(
    chatId: Long = 0L
): ChatInviteLink = chat(
    GenerateChatInviteLink(
        chatId
    )
)

/**
 * Generates a new invite link for a chat
 * The previously generated link is revoked
 * Available for basic groups, supergroups, and channels
 * Requires administrator privileges and can_invite_users right
 */
suspend fun TelegramClient.chat(
    f: GenerateChatInviteLink
): ChatInviteLink = exec(f) as ChatInviteLink

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
 * Uses an invite link to add the current user to the chat if possible
 * The new member will not be added until the chat state has been synchronized with the server
 *
 * @inviteLink - Invite link to import
 */
suspend fun TelegramClient.joinChatByInviteLink(
    inviteLink: String? = null
): Chat = chat(
    JoinChatByInviteLink(
        inviteLink
    )
)

/**
 * Uses an invite link to add the current user to the chat if possible
 * The new member will not be added until the chat state has been synchronized with the server
 */
suspend fun TelegramClient.chat(
    f: JoinChatByInviteLink
): Chat = exec(f) as Chat

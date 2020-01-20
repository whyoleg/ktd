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
 * Checks the validity of an invite link for a chat and returns information about the corresponding chat
 *
 * @inviteLink - Invite link to be checked
 */
suspend fun TelegramClient.checkChatInviteLink(
    inviteLink: String? = null
): ChatInviteLinkInfo = chat(
    CheckChatInviteLink(
        inviteLink
    )
)

/**
 * Checks the validity of an invite link for a chat and returns information about the corresponding chat
 */
suspend fun TelegramClient.chat(
    f: CheckChatInviteLink
): ChatInviteLinkInfo = exec(f) as ChatInviteLinkInfo

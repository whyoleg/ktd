package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Generates a new invite link for a chat
 * The previously generated link is revoked
 * Available for basic groups, supergroups, and channels
 * Requires administrator privileges and can_invite_users right
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.generateChatInviteLink(chatId: Long = 0L, extra: TdExtra =
        TdExtra.EMPTY): TdChatInviteLink = exec(TdGenerateChatInviteLink(chatId, extra))

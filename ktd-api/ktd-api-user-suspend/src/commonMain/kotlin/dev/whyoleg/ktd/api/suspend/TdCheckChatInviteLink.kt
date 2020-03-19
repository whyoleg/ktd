package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Checks the validity of an invite link for a chat and returns information about the corresponding chat
 *
 * @property inviteLink Invite link to be checked
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.checkChatInviteLink(inviteLink: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdChatInviteLinkInfo = exec(TdCheckChatInviteLink(inviteLink, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Uses an invite link to add the current user to the chat if possible
 * The new member will not be added until the chat state has been synchronized with the server
 *
 * @property inviteLink Invite link to import
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.joinChatByInviteLink(inviteLink: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdChat = exec(TdJoinChatByInviteLink(inviteLink, extra))

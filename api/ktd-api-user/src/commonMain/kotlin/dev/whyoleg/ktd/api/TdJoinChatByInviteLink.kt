package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Uses an invite link to add the current user to the chat if possible
 * The new member will not be added until the chat state has been synchronized with the server
 *
 * @property inviteLink Invite link to import
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("joinChatByInviteLink")
data class TdJoinChatByInviteLink(
    @SerialName("invite_link")
    val inviteLink: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChat> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdJoinChatByInviteLink {
        return copy(extra = extra.copy(id = id))
    }
}

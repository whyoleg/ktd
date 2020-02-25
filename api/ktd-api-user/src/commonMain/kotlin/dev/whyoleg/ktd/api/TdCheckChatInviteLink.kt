package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Checks the validity of an invite link for a chat and returns information about the corresponding chat
 *
 * @property inviteLink Invite link to be checked
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("checkChatInviteLink")
data class TdCheckChatInviteLink(
    @SerialName("invite_link")
    val inviteLink: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChatInviteLinkInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCheckChatInviteLink {
        return copy(extra = extra.copy(id = id))
    }
}

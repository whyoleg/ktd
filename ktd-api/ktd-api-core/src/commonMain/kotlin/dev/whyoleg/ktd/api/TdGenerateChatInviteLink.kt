package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Generates a new invite link for a chat
 * The previously generated link is revoked
 * Available for basic groups, supergroups, and channels
 * Requires administrator privileges and can_invite_users right
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("generateChatInviteLink")
data class TdGenerateChatInviteLink(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChatInviteLink> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGenerateChatInviteLink {
        return copy(extra = extra.copy(id = id))
    }
}

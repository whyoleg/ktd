package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a chat invite link
 *
 * @property inviteLink Chat invite link
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("chatInviteLink")
data class TdChatInviteLink(
    @SerialName("invite_link")
    val inviteLink: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

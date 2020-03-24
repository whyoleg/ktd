package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains full information about a basic group
 *
 * @property description Group description
 * @property creatorUserId User identifier of the creator of the group
 *                         0 if unknown
 * @property members Group members
 * @property inviteLink Invite link for this group
 *                      Available only after it has been generated at least once and only for the group creator
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("basicGroupFullInfo")
data class TdBasicGroupFullInfo(
    @SerialName("description")
    val description: String,
    @SerialName("creator_user_id")
    val creatorUserId: Int,
    @SerialName("members")
    val members: List<TdChatMember>,
    @SerialName("invite_link")
    val inviteLink: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

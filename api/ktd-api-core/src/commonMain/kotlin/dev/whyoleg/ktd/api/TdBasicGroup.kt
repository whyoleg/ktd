package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a basic group of 0-200 users (must be upgraded to a supergroup to accommodate more than 200 users)
 *
 * @property id Group identifier
 * @property memberCount Number of members in the group
 * @property status Status of the current user in the group
 * @property isActive True, if the group is active
 * @property upgradedToSupergroupId Identifier of the supergroup to which this group was upgraded
 *                                  0 if none
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("basicGroup")
data class TdBasicGroup(
    @SerialName("id")
    val id: Int,
    @SerialName("member_count")
    val memberCount: Int,
    @SerialName("status")
    val status: TdChatMemberStatus,
    @SerialName("is_active")
    val isActive: Boolean,
    @SerialName("upgraded_to_supergroup_id")
    val upgradedToSupergroupId: Int,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

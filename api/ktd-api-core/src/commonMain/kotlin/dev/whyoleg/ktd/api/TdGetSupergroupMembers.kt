package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about members or banned users in a supergroup or channel
 * Can be used only if SupergroupFullInfo.can_get_members == true
 * Additionally, administrator privileges may be required for some filters
 *
 * @property supergroupId Identifier of the supergroup or channel
 * @property filter The type of users to return
 *                  By default, supergroupMembersRecent
 * @property offset Number of users to skip
 * @property limit The maximum number of users be returned
 *                 Up to 200
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getSupergroupMembers")
data class TdGetSupergroupMembers(
    @SerialName("supergroup_id")
    val supergroupId: Int = 0,
    @SerialName("filter")
    val filter: TdSupergroupMembersFilter? = null,
    @SerialName("offset")
    val offset: Int = 0,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChatMembers> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetSupergroupMembers {
        return copy(extra = extra.copy(id = id))
    }
}

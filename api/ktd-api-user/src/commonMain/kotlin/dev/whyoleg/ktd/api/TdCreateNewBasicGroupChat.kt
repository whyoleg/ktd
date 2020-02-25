package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Creates a new basic group and sends a corresponding messageBasicGroupChatCreate
 * Returns the newly created chat
 *
 * @property userIds Identifiers of users to be added to the basic group
 * @property title Title of the new basic group
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("createNewBasicGroupChat")
data class TdCreateNewBasicGroupChat(
    @SerialName("user_ids")
    val userIds: IntArray = intArrayOf(),
    @SerialName("title")
    val title: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChat> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCreateNewBasicGroupChat {
        return copy(extra = extra.copy(id = id))
    }
}

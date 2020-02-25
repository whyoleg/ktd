package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Deletes a supergroup or channel along with all messages in the corresponding chat
 * This will release the supergroup or channel username and remove all members
 * Requires owner privileges in the supergroup or channel
 * Chats with more than 1000 members can't be deleted using this method
 *
 * @property supergroupId Identifier of the supergroup or channel
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("deleteSupergroup")
data class TdDeleteSupergroup(
    @SerialName("supergroup_id")
    val supergroupId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDeleteSupergroup {
        return copy(extra = extra.copy(id = id))
    }
}

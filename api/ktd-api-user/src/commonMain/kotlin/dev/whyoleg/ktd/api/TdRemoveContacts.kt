package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes users from the contact list
 *
 * @property userIds Identifiers of users to be deleted
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("removeContacts")
data class TdRemoveContacts(
    @SerialName("user_ids")
    val userIds: IntArray = intArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRemoveContacts {
        return copy(extra = extra.copy(id = id))
    }
}

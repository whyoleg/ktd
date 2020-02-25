package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns users that were blocked by the current user
 *
 * @property offset Number of users to skip in the result
 * @property limit The maximum number of users to return
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getBlockedUsers")
data class TdGetBlockedUsers(
    @SerialName("offset")
    val offset: Int = 0,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdUsers> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetBlockedUsers {
        return copy(extra = extra.copy(id = id))
    }
}

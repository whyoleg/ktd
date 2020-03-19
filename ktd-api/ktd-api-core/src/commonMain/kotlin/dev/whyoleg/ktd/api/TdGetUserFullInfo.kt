package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns full information about a user by their identifier
 *
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getUserFullInfo")
data class TdGetUserFullInfo(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdUserFullInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetUserFullInfo {
        return copy(extra = extra.copy(id = id))
    }
}

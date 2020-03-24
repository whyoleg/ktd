package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a user by their identifier
 * This is an offline request if the current user is not a bot
 *
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getUser")
data class TdGetUser(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdUser> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetUser {
        return copy(extra = extra.copy(id = id))
    }
}

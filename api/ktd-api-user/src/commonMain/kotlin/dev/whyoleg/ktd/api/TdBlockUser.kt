package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds a user to the blacklist
 *
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("blockUser")
data class TdBlockUser(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdBlockUser {
        return copy(extra = extra.copy(id = id))
    }
}

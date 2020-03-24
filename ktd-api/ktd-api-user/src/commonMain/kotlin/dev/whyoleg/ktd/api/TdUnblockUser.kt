package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes a user from the blacklist
 *
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("unblockUser")
data class TdUnblockUser(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdUnblockUser {
        return copy(extra = extra.copy(id = id))
    }
}

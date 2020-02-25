package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a supergroup or a channel by its identifier
 * This is an offline request if the current user is not a bot
 *
 * @property supergroupId Supergroup or channel identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getSupergroup")
data class TdGetSupergroup(
    @SerialName("supergroup_id")
    val supergroupId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdSupergroup> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetSupergroup {
        return copy(extra = extra.copy(id = id))
    }
}

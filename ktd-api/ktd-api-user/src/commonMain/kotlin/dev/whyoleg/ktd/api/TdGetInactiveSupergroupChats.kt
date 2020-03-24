package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a list of recently inactive supergroups and channels
 * Can be used when user reaches limit on the number of joined supergroups and channels and receives CHANNELS_TOO_MUCH error
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getInactiveSupergroupChats")
data class TdGetInactiveSupergroupChats(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChats> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetInactiveSupergroupChats {
        return copy(extra = extra.copy(id = id))
    }
}

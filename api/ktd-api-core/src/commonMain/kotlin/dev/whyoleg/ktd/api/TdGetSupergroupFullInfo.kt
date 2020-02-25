package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns full information about a supergroup or a channel by its identifier, cached for up to 1 minute
 *
 * @property supergroupId Supergroup or channel identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getSupergroupFullInfo")
data class TdGetSupergroupFullInfo(
    @SerialName("supergroup_id")
    val supergroupId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdSupergroupFullInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetSupergroupFullInfo {
        return copy(extra = extra.copy(id = id))
    }
}

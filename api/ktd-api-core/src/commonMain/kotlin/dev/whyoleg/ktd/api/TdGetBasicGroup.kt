package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a basic group by its identifier
 * This is an offline request if the current user is not a bot
 *
 * @property basicGroupId Basic group identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getBasicGroup")
data class TdGetBasicGroup(
    @SerialName("basic_group_id")
    val basicGroupId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdBasicGroup> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetBasicGroup {
        return copy(extra = extra.copy(id = id))
    }
}

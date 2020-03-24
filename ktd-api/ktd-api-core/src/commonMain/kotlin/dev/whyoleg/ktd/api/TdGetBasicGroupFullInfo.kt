package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns full information about a basic group by its identifier
 *
 * @property basicGroupId Basic group identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getBasicGroupFullInfo")
data class TdGetBasicGroupFullInfo(
    @SerialName("basic_group_id")
    val basicGroupId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdBasicGroupFullInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetBasicGroupFullInfo {
        return copy(extra = extra.copy(id = id))
    }
}

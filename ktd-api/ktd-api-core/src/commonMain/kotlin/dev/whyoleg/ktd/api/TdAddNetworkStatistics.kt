package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds the specified data to data usage statistics
 * Can be called before authorization
 *
 * @property entry The network statistics entry with the data to be added to statistics
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("addNetworkStatistics")
data class TdAddNetworkStatistics(
    @SerialName("entry")
    val entry: TdNetworkStatisticsEntry? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAddNetworkStatistics {
        return copy(extra = extra.copy(id = id))
    }
}

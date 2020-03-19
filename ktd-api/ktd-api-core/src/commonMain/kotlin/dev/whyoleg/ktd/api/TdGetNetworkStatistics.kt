package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns network data usage statistics
 * Can be called before authorization
 *
 * @property onlyCurrent If true, returns only data for the current library launch
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getNetworkStatistics")
data class TdGetNetworkStatistics(
    @SerialName("only_current")
    val onlyCurrent: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdNetworkStatistics> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetNetworkStatistics {
        return copy(extra = extra.copy(id = id))
    }
}

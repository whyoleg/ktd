package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Resets all network data usage statistics to zero
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("resetNetworkStatistics")
data class TdResetNetworkStatistics(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdResetNetworkStatistics {
        return copy(extra = extra.copy(id = id))
    }
}

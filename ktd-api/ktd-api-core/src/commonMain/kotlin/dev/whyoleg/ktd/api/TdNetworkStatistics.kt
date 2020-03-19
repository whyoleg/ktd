package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A full list of available network statistic entries
 *
 * @property sinceDate Point in time (Unix timestamp) when the app began collecting statistics
 * @property entries Network statistics entries
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("networkStatistics")
data class TdNetworkStatistics(
    @SerialName("since_date")
    val sinceDate: Int,
    @SerialName("entries")
    val entries: List<TdNetworkStatisticsEntry>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

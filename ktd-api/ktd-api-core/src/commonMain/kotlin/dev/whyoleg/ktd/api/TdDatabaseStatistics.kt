package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains database statistics
 *
 * @property statistics Database statistics in an unspecified human-readable format
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("databaseStatistics")
data class TdDatabaseStatistics(
    @SerialName("statistics")
    val statistics: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

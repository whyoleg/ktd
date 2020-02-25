package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns database statistics
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getDatabaseStatistics")
data class TdGetDatabaseStatistics(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdDatabaseStatistics> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetDatabaseStatistics {
        return copy(extra = extra.copy(id = id))
    }
}

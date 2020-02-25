package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Quickly returns approximate storage usage statistics
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getStorageStatisticsFast")
data class TdGetStorageStatisticsFast(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStorageStatisticsFast> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetStorageStatisticsFast {
        return copy(extra = extra.copy(id = id))
    }
}

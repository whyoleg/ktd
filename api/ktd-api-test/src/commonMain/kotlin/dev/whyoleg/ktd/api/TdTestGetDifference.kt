package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Forces an updates.getDifference call to the Telegram servers
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testGetDifference")
data class TdTestGetDifference(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTestGetDifference {
        return copy(extra = extra.copy(id = id))
    }
}

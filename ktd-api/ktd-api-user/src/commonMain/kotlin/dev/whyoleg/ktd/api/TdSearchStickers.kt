package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for stickers from public sticker sets that correspond to a given emoji
 *
 * @property emoji String representation of emoji
 * @property limit The maximum number of stickers to be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchStickers")
data class TdSearchStickers(
    @SerialName("emoji")
    val emoji: String? = null,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickers> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchStickers {
        return copy(extra = extra.copy(id = id))
    }
}

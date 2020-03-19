package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for installed sticker sets by looking for specified query in their title and name
 *
 * @property isMasks Pass true to return mask sticker sets
 *                   Pass false to return ordinary sticker sets
 * @property query Query to search for
 * @property limit The maximum number of sticker sets to return
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchInstalledStickerSets")
data class TdSearchInstalledStickerSets(
    @SerialName("is_masks")
    val isMasks: Boolean = false,
    @SerialName("query")
    val query: String? = null,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickerSets> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchInstalledStickerSets {
        return copy(extra = extra.copy(id = id))
    }
}

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for ordinary sticker sets by looking for specified query in their title and name
 * Excludes installed sticker sets from the results
 *
 * @property query Query to search for
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchStickerSets")
data class TdSearchStickerSets(
    @SerialName("query")
    val query: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickerSets> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchStickerSets {
        return copy(extra = extra.copy(id = id))
    }
}

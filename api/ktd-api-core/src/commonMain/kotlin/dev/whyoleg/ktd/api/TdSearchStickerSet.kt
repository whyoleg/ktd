package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for a sticker set by its name
 *
 * @property name Name of the sticker set
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchStickerSet")
data class TdSearchStickerSet(
    @SerialName("name")
    val name: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickerSet> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchStickerSet {
        return copy(extra = extra.copy(id = id))
    }
}

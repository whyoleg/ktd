package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a sticker set by its identifier
 *
 * @property setId Identifier of the sticker set
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getStickerSet")
data class TdGetStickerSet(
    @SerialName("set_id")
    val setId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickerSet> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetStickerSet {
        return copy(extra = extra.copy(id = id))
    }
}

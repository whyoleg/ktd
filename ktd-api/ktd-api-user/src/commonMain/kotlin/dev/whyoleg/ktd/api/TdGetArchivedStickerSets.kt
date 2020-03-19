package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a list of archived sticker sets
 *
 * @property isMasks Pass true to return mask stickers sets
 *                   Pass false to return ordinary sticker sets
 * @property offsetStickerSetId Identifier of the sticker set from which to return the result
 * @property limit The maximum number of sticker sets to return
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getArchivedStickerSets")
data class TdGetArchivedStickerSets(
    @SerialName("is_masks")
    val isMasks: Boolean = false,
    @SerialName("offset_sticker_set_id")
    val offsetStickerSetId: Long = 0L,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickerSets> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetArchivedStickerSets {
        return copy(extra = extra.copy(id = id))
    }
}

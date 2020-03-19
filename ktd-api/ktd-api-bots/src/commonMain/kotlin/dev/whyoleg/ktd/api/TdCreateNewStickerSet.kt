package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Creates a new sticker set
 * Returns the newly created sticker set
 *
 * @property userId Sticker set owner
 * @property title Sticker set title
 * @property name Sticker set name
 *                Can contain only English letters, digits and underscores
 *                Must end with *"_by_<bot username>"* (*<bot_username>* is case insensitive)
 * @property isMasks True, if stickers are masks
 * @property stickers List of stickers to be added to the set
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("createNewStickerSet")
data class TdCreateNewStickerSet(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("title")
    val title: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("is_masks")
    val isMasks: Boolean = false,
    @SerialName("stickers")
    val stickers: List<TdInputSticker> = emptyList(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickerSet> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCreateNewStickerSet {
        return copy(extra = extra.copy(id = id))
    }
}

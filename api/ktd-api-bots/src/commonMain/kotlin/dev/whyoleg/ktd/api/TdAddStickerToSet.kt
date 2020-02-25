package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds a new sticker to a set
 * Returns the sticker set
 *
 * @property userId Sticker set owner
 * @property name Sticker set name
 * @property sticker Sticker to add to the set
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("addStickerToSet")
data class TdAddStickerToSet(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("name")
    val name: String? = null,
    @SerialName("sticker")
    val sticker: TdInputSticker? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickerSet> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAddStickerToSet {
        return copy(extra = extra.copy(id = id))
    }
}

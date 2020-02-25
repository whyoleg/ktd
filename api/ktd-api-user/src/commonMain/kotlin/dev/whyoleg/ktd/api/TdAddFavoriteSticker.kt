package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds a new sticker to the list of favorite stickers
 * The new sticker is added to the top of the list
 * If the sticker was already in the list, it is removed from the list first
 * Only stickers belonging to a sticker set can be added to this list
 *
 * @property sticker Sticker file to add
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("addFavoriteSticker")
data class TdAddFavoriteSticker(
    @SerialName("sticker")
    val sticker: TdInputFile? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAddFavoriteSticker {
        return copy(extra = extra.copy(id = id))
    }
}

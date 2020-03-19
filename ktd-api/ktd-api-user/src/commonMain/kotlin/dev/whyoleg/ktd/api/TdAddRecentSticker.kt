package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Manually adds a new sticker to the list of recently used stickers
 * The new sticker is added to the top of the list
 * If the sticker was already in the list, it is removed from the list first
 * Only stickers belonging to a sticker set can be added to this list
 *
 * @property isAttached Pass true to add the sticker to the list of stickers recently attached to photo or video files
 *                      Pass false to add the sticker to the list of recently sent stickers
 * @property sticker Sticker file to add
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("addRecentSticker")
data class TdAddRecentSticker(
    @SerialName("is_attached")
    val isAttached: Boolean = false,
    @SerialName("sticker")
    val sticker: TdInputFile? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickers> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAddRecentSticker {
        return copy(extra = extra.copy(id = id))
    }
}

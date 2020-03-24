package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes a sticker from the list of recently used stickers
 *
 * @property isAttached Pass true to remove the sticker from the list of stickers recently attached to photo or video files
 *                      Pass false to remove the sticker from the list of recently sent stickers
 * @property sticker Sticker file to delete
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("removeRecentSticker")
data class TdRemoveRecentSticker(
    @SerialName("is_attached")
    val isAttached: Boolean = false,
    @SerialName("sticker")
    val sticker: TdInputFile? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRemoveRecentSticker {
        return copy(extra = extra.copy(id = id))
    }
}

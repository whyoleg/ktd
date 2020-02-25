package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * The list of recently used stickers was updated
 *
 * @property isAttached True, if the list of stickers attached to photo or video files was updated, otherwise the list of sent stickers is updated
 * @property stickerIds The new list of file identifiers of recently used stickers
 */
@Serializable
@SerialName("updateRecentStickers")
data class TdUpdateRecentStickers(
    @SerialName("is_attached")
    val isAttached: Boolean,
    @SerialName("sticker_ids")
    val stickerIds: IntArray
) : TdUpdate

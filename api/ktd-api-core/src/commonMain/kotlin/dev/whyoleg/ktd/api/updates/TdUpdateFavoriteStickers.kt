package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * The list of favorite stickers was updated
 *
 * @property stickerIds The new list of file identifiers of favorite stickers
 */
@Serializable
@SerialName("updateFavoriteStickers")
data class TdUpdateFavoriteStickers(
    @SerialName("sticker_ids")
    val stickerIds: IntArray
) : TdUpdate

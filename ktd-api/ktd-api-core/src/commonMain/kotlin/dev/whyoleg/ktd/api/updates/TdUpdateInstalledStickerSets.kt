package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * The list of installed sticker sets was updated
 *
 * @property isMasks True, if the list of installed mask sticker sets was updated
 * @property stickerSetIds The new list of installed ordinary sticker sets
 */
@Serializable
@SerialName("updateInstalledStickerSets")
data class TdUpdateInstalledStickerSets(
    @SerialName("is_masks")
    val isMasks: Boolean,
    @SerialName("sticker_set_ids")
    val stickerSetIds: LongArray
) : TdUpdate

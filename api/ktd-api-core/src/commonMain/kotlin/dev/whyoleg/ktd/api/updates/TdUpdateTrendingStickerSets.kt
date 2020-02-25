package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * The list of trending sticker sets was updated or some of them were viewed
 *
 * @property stickerSets The new list of trending sticker sets
 */
@Serializable
@SerialName("updateTrendingStickerSets")
data class TdUpdateTrendingStickerSets(
    @SerialName("sticker_sets")
    val stickerSets: TdStickerSets
) : TdUpdate

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a list of stickers
 *
 * @property stickers List of stickers
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("stickers")
data class TdStickers(
    @SerialName("stickers")
    val stickers: List<TdSticker>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

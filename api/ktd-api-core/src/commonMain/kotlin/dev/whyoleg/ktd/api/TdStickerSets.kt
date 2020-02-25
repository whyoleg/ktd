package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a list of sticker sets
 *
 * @property totalCount Approximate total number of sticker sets found
 * @property sets List of sticker sets
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("stickerSets")
data class TdStickerSets(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("sets")
    val sets: List<TdStickerSetInfo>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

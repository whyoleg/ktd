package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns emoji corresponding to a sticker
 * The list is only for informational purposes, because a sticker is always sent with a fixed emoji from the corresponding Sticker object
 *
 * @property sticker Sticker file identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getStickerEmojis")
data class TdGetStickerEmojis(
    @SerialName("sticker")
    val sticker: TdInputFile? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdEmojis> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetStickerEmojis {
        return copy(extra = extra.copy(id = id))
    }
}

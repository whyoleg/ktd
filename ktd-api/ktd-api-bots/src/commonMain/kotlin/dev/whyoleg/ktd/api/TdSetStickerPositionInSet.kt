package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the position of a sticker in the set to which it belongs
 * The sticker set must have been created by the bot
 *
 * @property sticker Sticker
 * @property position New position of the sticker in the set, zero-based
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setStickerPositionInSet")
data class TdSetStickerPositionInSet(
    @SerialName("sticker")
    val sticker: TdInputFile? = null,
    @SerialName("position")
    val position: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetStickerPositionInSet {
        return copy(extra = extra.copy(id = id))
    }
}

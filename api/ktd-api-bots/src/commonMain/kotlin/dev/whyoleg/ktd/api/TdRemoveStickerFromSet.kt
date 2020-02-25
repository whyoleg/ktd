package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes a sticker from the set to which it belongs
 * The sticker set must have been created by the bot
 *
 * @property sticker Sticker
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("removeStickerFromSet")
data class TdRemoveStickerFromSet(
    @SerialName("sticker")
    val sticker: TdInputFile? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRemoveStickerFromSet {
        return copy(extra = extra.copy(id = id))
    }
}

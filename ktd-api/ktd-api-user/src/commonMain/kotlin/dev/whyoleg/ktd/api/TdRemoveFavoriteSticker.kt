package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes a sticker from the list of favorite stickers
 *
 * @property sticker Sticker file to delete from the list
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("removeFavoriteSticker")
data class TdRemoveFavoriteSticker(
    @SerialName("sticker")
    val sticker: TdInputFile? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRemoveFavoriteSticker {
        return copy(extra = extra.copy(id = id))
    }
}

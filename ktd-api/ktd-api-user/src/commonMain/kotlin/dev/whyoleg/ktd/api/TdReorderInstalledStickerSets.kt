package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the order of installed sticker sets
 *
 * @property isMasks Pass true to change the order of mask sticker sets
 *                   Pass false to change the order of ordinary sticker sets
 * @property stickerSetIds Identifiers of installed sticker sets in the new correct order
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("reorderInstalledStickerSets")
data class TdReorderInstalledStickerSets(
    @SerialName("is_masks")
    val isMasks: Boolean = false,
    @SerialName("sticker_set_ids")
    val stickerSetIds: LongArray = longArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdReorderInstalledStickerSets {
        return copy(extra = extra.copy(id = id))
    }
}

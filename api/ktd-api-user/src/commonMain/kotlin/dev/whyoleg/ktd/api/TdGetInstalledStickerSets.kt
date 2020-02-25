package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a list of installed sticker sets
 *
 * @property isMasks Pass true to return mask sticker sets
 *                   Pass false to return ordinary sticker sets
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getInstalledStickerSets")
data class TdGetInstalledStickerSets(
    @SerialName("is_masks")
    val isMasks: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickerSets> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetInstalledStickerSets {
        return copy(extra = extra.copy(id = id))
    }
}

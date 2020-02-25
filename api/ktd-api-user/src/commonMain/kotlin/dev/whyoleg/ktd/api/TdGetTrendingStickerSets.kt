package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a list of trending sticker sets
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getTrendingStickerSets")
data class TdGetTrendingStickerSets(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickerSets> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetTrendingStickerSets {
        return copy(extra = extra.copy(id = id))
    }
}

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns favorite stickers
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getFavoriteStickers")
data class TdGetFavoriteStickers(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickers> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetFavoriteStickers {
        return copy(extra = extra.copy(id = id))
    }
}

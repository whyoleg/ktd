package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a list of recently used stickers
 *
 * @property isAttached Pass true to return stickers and masks that were recently attached to photos or video files
 *                      Pass false to return recently sent stickers
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getRecentStickers")
data class TdGetRecentStickers(
    @SerialName("is_attached")
    val isAttached: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickers> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetRecentStickers {
        return copy(extra = extra.copy(id = id))
    }
}

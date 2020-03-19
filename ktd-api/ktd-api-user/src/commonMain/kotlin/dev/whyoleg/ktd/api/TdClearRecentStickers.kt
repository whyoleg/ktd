package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Clears the list of recently used stickers
 *
 * @property isAttached Pass true to clear the list of stickers recently attached to photo or video files
 *                      Pass false to clear the list of recently sent stickers
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("clearRecentStickers")
data class TdClearRecentStickers(
    @SerialName("is_attached")
    val isAttached: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdClearRecentStickers {
        return copy(extra = extra.copy(id = id))
    }
}

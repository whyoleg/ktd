package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns stickers from the installed sticker sets that correspond to a given emoji
 * If the emoji is not empty, favorite and recently used stickers may also be returned
 *
 * @property emoji String representation of emoji
 *                 If empty, returns all known installed stickers
 * @property limit The maximum number of stickers to be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getStickers")
data class TdGetStickers(
    @SerialName("emoji")
    val emoji: String? = null,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickers> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetStickers {
        return copy(extra = extra.copy(id = id))
    }
}

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a list of sticker sets attached to a file
 * Currently only photos and videos can have attached sticker sets
 *
 * @property fileId File identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getAttachedStickerSets")
data class TdGetAttachedStickerSets(
    @SerialName("file_id")
    val fileId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdStickerSets> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetAttachedStickerSets {
        return copy(extra = extra.copy(id = id))
    }
}

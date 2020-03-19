package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Informs the server that some trending sticker sets have been viewed by the user
 *
 * @property stickerSetIds Identifiers of viewed trending sticker sets
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("viewTrendingStickerSets")
data class TdViewTrendingStickerSets(
    @SerialName("sticker_set_ids")
    val stickerSetIds: LongArray = longArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdViewTrendingStickerSets {
        return copy(extra = extra.copy(id = id))
    }
}

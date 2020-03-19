package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the sticker set of a supergroup
 * Requires can_change_info rights
 *
 * @property supergroupId Identifier of the supergroup
 * @property stickerSetId New value of the supergroup sticker set identifier
 *                        Use 0 to remove the supergroup sticker set
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setSupergroupStickerSet")
data class TdSetSupergroupStickerSet(
    @SerialName("supergroup_id")
    val supergroupId: Int = 0,
    @SerialName("sticker_set_id")
    val stickerSetId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetSupergroupStickerSet {
        return copy(extra = extra.copy(id = id))
    }
}

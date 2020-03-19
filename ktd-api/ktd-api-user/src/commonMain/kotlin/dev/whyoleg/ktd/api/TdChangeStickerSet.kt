package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Installs/uninstalls or activates/archives a sticker set
 *
 * @property setId Identifier of the sticker set
 * @property isInstalled The new value of is_installed
 * @property isArchived The new value of is_archived
 *                      A sticker set can't be installed and archived simultaneously
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("changeStickerSet")
data class TdChangeStickerSet(
    @SerialName("set_id")
    val setId: Long = 0L,
    @SerialName("is_installed")
    val isInstalled: Boolean = false,
    @SerialName("is_archived")
    val isArchived: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdChangeStickerSet {
        return copy(extra = extra.copy(id = id))
    }
}

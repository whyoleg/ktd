package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a sticker set
 *
 * @property id Identifier of the sticker set
 * @property title Title of the sticker set
 * @property name Name of the sticker set
 * @property thumbnail Sticker set thumbnail in WEBP format with width and height 100
 *                     The file can be downloaded only before the thumbnail is changed
 * @property isInstalled True, if the sticker set has been installed by the current user
 * @property isArchived True, if the sticker set has been archived
 *                      A sticker set can't be installed and archived simultaneously
 * @property isOfficial True, if the sticker set is official
 * @property isAnimated True, is the stickers in the set are animated
 * @property isMasks True, if the stickers in the set are masks
 * @property isViewed True for already viewed trending sticker sets
 * @property stickers List of stickers in this set
 * @property emojis A list of emoji corresponding to the stickers in the same order
 *                  The list is only for informational purposes, because a sticker is always sent with a fixed emoji from the corresponding Sticker object
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("stickerSet")
data class TdStickerSet(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("name")
    val name: String,
    @SerialName("thumbnail")
    val thumbnail: TdPhotoSize?,
    @SerialName("is_installed")
    val isInstalled: Boolean,
    @SerialName("is_archived")
    val isArchived: Boolean,
    @SerialName("is_official")
    val isOfficial: Boolean,
    @SerialName("is_animated")
    val isAnimated: Boolean,
    @SerialName("is_masks")
    val isMasks: Boolean,
    @SerialName("is_viewed")
    val isViewed: Boolean,
    @SerialName("stickers")
    val stickers: List<TdSticker>,
    @SerialName("emojis")
    val emojis: List<TdEmojis>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

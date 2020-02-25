package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents short information about a sticker set
 *
 * @property id Identifier of the sticker set
 * @property title Title of the sticker set
 * @property name Name of the sticker set
 * @property thumbnail Sticker set thumbnail in WEBP format with width and height 100
 * @property isInstalled True, if the sticker set has been installed by current user
 * @property isArchived True, if the sticker set has been archived
 *                      A sticker set can't be installed and archived simultaneously
 * @property isOfficial True, if the sticker set is official
 * @property isAnimated True, is the stickers in the set are animated
 * @property isMasks True, if the stickers in the set are masks
 * @property isViewed True for already viewed trending sticker sets
 * @property size Total number of stickers in the set
 * @property covers Contains up to the first 5 stickers from the set, depending on the context
 *                  If the client needs more stickers the full set should be requested
 */
@Serializable
@SerialName("stickerSetInfo")
data class TdStickerSetInfo(
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
    @SerialName("size")
    val size: Int,
    @SerialName("covers")
    val covers: List<TdSticker>
) : TdObject

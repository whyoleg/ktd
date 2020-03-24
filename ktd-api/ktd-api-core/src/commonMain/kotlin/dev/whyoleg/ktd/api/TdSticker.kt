package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a sticker
 *
 * @property setId The identifier of the sticker set to which the sticker belongs
 *                 0 if none
 * @property width Sticker width
 *                 As defined by the sender
 * @property height Sticker height
 *                  As defined by the sender
 * @property emoji Emoji corresponding to the sticker
 * @property isAnimated True, if the sticker is an animated sticker in TGS format
 * @property isMask True, if the sticker is a mask
 * @property maskPosition Position where the mask should be placed
 * @property thumbnail Sticker thumbnail in WEBP or JPEG format
 * @property sticker File containing the sticker
 */
@Serializable
@SerialName("sticker")
data class TdSticker(
    @SerialName("set_id")
    val setId: Long,
    @SerialName("width")
    val width: Int,
    @SerialName("height")
    val height: Int,
    @SerialName("emoji")
    val emoji: String,
    @SerialName("is_animated")
    val isAnimated: Boolean,
    @SerialName("is_mask")
    val isMask: Boolean,
    @SerialName("mask_position")
    val maskPosition: TdMaskPosition?,
    @SerialName("thumbnail")
    val thumbnail: TdPhotoSize?,
    @SerialName("sticker")
    val sticker: TdFile
) : TdObject

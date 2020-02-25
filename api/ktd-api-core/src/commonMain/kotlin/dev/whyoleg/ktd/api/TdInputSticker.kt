package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a sticker that should be added to a sticker set
 *
 * @property pngSticker PNG image with the sticker
 *                      Must be up to 512 kB in size and fit in a 512x512 square
 * @property emojis Emoji corresponding to the sticker
 * @property maskPosition For masks, position where the mask should be placed
 */
@Serializable
@SerialName("inputSticker")
data class TdInputSticker(
    @SerialName("png_sticker")
    val pngSticker: TdInputFile,
    @SerialName("emojis")
    val emojis: String,
    @SerialName("mask_position")
    val maskPosition: TdMaskPosition?
) : TdObject

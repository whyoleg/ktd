package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Position on a photo where a mask should be placed
 *
 * @property point Part of the face, relative to which the mask should be placed
 * @property xShift Shift by X-axis measured in widths of the mask scaled to the face size, from left to right
 *                  (For example, -1.0 will place the mask just to the left of the default mask position)
 * @property yShift Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom
 *                  (For example, 1.0 will place the mask just below the default mask position)
 * @property scale Mask scaling coefficient
 *                 (For example, 2.0 means a doubled size)
 */
@Serializable
@SerialName("maskPosition")
data class TdMaskPosition(
    @SerialName("point")
    val point: TdMaskPoint,
    @SerialName("x_shift")
    val xShift: Double,
    @SerialName("y_shift")
    val yShift: Double,
    @SerialName("scale")
    val scale: Double
) : TdObject

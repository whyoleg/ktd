package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a fill of a background
 */
@Serializable
sealed class TdBackgroundFill : TdObject {
    /**
     * Describes a solid fill of a background
     *
     * @property color A color of the background in the RGB24 format
     */
    @Serializable
    @SerialName("backgroundFillSolid")
    data class Solid(
        @SerialName("color")
        val color: Int
    ) : TdBackgroundFill()

    /**
     * Describes a gradient fill of a background
     *
     * @property topColor A top color of the background in the RGB24 format
     * @property bottomColor A bottom color of the background in the RGB24 format
     * @property rotationAngle Clockwise rotation angle of the gradient, in degrees
     *                         Should be always divisible by 45
     */
    @Serializable
    @SerialName("backgroundFillGradient")
    data class Gradient(
        @SerialName("top_color")
        val topColor: Int,
        @SerialName("bottom_color")
        val bottomColor: Int,
        @SerialName("rotation_angle")
        val rotationAngle: Int
    ) : TdBackgroundFill()
}

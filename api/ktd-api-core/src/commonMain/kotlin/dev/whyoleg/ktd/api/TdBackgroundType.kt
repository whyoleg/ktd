package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the type of a background
 */
@Serializable
sealed class TdBackgroundType : TdObject {
    /**
     * A wallpaper in JPEG format
     *
     * @property isBlurred True, if the wallpaper must be downscaled to fit in 450x450 square and then box-blurred with radius 12
     * @property isMoving True, if the background needs to be slightly moved when device is tilted
     */
    @Serializable
    @SerialName("backgroundTypeWallpaper")
    data class Wallpaper(
        @SerialName("is_blurred")
        val isBlurred: Boolean,
        @SerialName("is_moving")
        val isMoving: Boolean
    ) : TdBackgroundType()

    /**
     * A PNG or TGV (gzipped subset of SVG with MIME type "application/x-tgwallpattern") pattern to be combined with the background fill chosen by the user
     *
     * @property fill Description of the background fill
     * @property intensity Intensity of the pattern when it is shown above the filled background, 0-100
     * @property isMoving True, if the background needs to be slightly moved when device is tilted
     */
    @Serializable
    @SerialName("backgroundTypePattern")
    data class Pattern(
        @SerialName("fill")
        val fill: TdBackgroundFill,
        @SerialName("intensity")
        val intensity: Int,
        @SerialName("is_moving")
        val isMoving: Boolean
    ) : TdBackgroundType()

    /**
     * A filled background
     *
     * @property fill Description of the background fill
     */
    @Serializable
    @SerialName("backgroundTypeFill")
    data class Fill(
        @SerialName("fill")
        val fill: TdBackgroundFill
    ) : TdBackgroundType()
}

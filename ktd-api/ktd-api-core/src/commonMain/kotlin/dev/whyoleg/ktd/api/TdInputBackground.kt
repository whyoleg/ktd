package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about background to set
 */
@Serializable
sealed class TdInputBackground : TdObject {
    /**
     * A background from a local file
     *
     * @property background Background file to use
     *                      Only inputFileLocal and inputFileGenerated are supported
     *                      The file must be in JPEG format for wallpapers and in PNG format for patterns
     */
    @Serializable
    @SerialName("inputBackgroundLocal")
    data class Local(
        @SerialName("background")
        val background: TdInputFile
    ) : TdInputBackground()

    /**
     * A background from the server
     *
     * @property backgroundId The background identifier
     */
    @Serializable
    @SerialName("inputBackgroundRemote")
    data class Remote(
        @SerialName("background_id")
        val backgroundId: Long
    ) : TdInputBackground()
}

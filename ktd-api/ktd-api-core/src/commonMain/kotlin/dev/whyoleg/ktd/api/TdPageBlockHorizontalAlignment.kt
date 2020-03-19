package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a horizontal alignment of a table cell content
 */
@Serializable
sealed class TdPageBlockHorizontalAlignment : TdObject {
    /**
     * The content should be left-aligned
     */
    @Serializable
    @SerialName("pageBlockHorizontalAlignmentLeft")
    object Left : TdPageBlockHorizontalAlignment()

    /**
     * The content should be center-aligned
     */
    @Serializable
    @SerialName("pageBlockHorizontalAlignmentCenter")
    object Center : TdPageBlockHorizontalAlignment()

    /**
     * The content should be right-aligned
     */
    @Serializable
    @SerialName("pageBlockHorizontalAlignmentRight")
    object Right : TdPageBlockHorizontalAlignment()
}

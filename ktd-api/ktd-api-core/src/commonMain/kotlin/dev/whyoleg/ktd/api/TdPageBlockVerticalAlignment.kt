package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a Vertical alignment of a table cell content
 */
@Serializable
sealed class TdPageBlockVerticalAlignment : TdObject {
    /**
     * The content should be top-aligned
     */
    @Serializable
    @SerialName("pageBlockVerticalAlignmentTop")
    object Top : TdPageBlockVerticalAlignment()

    /**
     * The content should be middle-aligned
     */
    @Serializable
    @SerialName("pageBlockVerticalAlignmentMiddle")
    object Middle : TdPageBlockVerticalAlignment()

    /**
     * The content should be bottom-aligned
     */
    @Serializable
    @SerialName("pageBlockVerticalAlignmentBottom")
    object Bottom : TdPageBlockVerticalAlignment()
}

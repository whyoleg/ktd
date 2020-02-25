package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a caption of an instant view web page block, consisting of a text and a trailing credit
 *
 * @property text Content of the caption
 * @property credit Block credit (like HTML tag <cite>)
 */
@Serializable
@SerialName("pageBlockCaption")
data class TdPageBlockCaption(
    @SerialName("text")
    val text: TdRichText,
    @SerialName("credit")
    val credit: TdRichText
) : TdObject

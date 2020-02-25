package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A text with some entities
 *
 * @property text The text
 * @property entities Entities contained in the text
 *                    Entities can be nested, but must not mutually intersect with each other
 *                    Pre, Code and PreCode entities can't contain other entities
 *                    Bold, Italic, Underline and Strikethrough entities can contain and to be contained in all other entities
 *                    All other entities can't contain each other
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("formattedText")
data class TdFormattedText(
    @SerialName("text")
    val text: String,
    @SerialName("entities")
    val entities: List<TdTextEntity>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

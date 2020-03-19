package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a cell of a table
 *
 * @property text Cell text
 *                If the text is null, then the cell should be invisible
 * @property isHeader True, if it is a header cell
 * @property colspan The number of columns the cell should span
 * @property rowspan The number of rows the cell should span
 * @property align Horizontal cell content alignment
 * @property valign Vertical cell content alignment
 */
@Serializable
@SerialName("pageBlockTableCell")
data class TdPageBlockTableCell(
    @SerialName("text")
    val text: TdRichText?,
    @SerialName("is_header")
    val isHeader: Boolean,
    @SerialName("colspan")
    val colspan: Int,
    @SerialName("rowspan")
    val rowspan: Int,
    @SerialName("align")
    val align: TdPageBlockHorizontalAlignment,
    @SerialName("valign")
    val valign: TdPageBlockVerticalAlignment
) : TdObject

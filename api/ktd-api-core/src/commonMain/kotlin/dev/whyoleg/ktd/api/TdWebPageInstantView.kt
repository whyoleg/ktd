package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes an instant view page for a web page
 *
 * @property pageBlocks Content of the web page
 * @property version Version of the instant view, currently can be 1 or 2
 * @property url Instant view URL
 *               May be different from WebPage.url and must be used for the correct anchors handling
 * @property isRtl True, if the instant view must be shown from right to left
 * @property isFull True, if the instant view contains the full page
 *                  A network request might be needed to get the full web page instant view
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("webPageInstantView")
data class TdWebPageInstantView(
    @SerialName("page_blocks")
    val pageBlocks: List<TdPageBlock>,
    @SerialName("version")
    val version: Int,
    @SerialName("url")
    val url: String,
    @SerialName("is_rtl")
    val isRtl: Boolean,
    @SerialName("is_full")
    val isFull: Boolean,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

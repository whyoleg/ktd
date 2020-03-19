package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes an item of a list page block
 *
 * @property label Item label
 * @property pageBlocks Item blocks
 */
@Serializable
@SerialName("pageBlockListItem")
data class TdPageBlockListItem(
    @SerialName("label")
    val label: String,
    @SerialName("page_blocks")
    val pageBlocks: List<TdPageBlock>
) : TdObject

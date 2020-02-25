package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * One shipping option
 *
 * @property id Shipping option identifier
 * @property title Option title
 * @property priceParts A list of objects used to calculate the total shipping costs
 */
@Serializable
@SerialName("shippingOption")
data class TdShippingOption(
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String,
    @SerialName("price_parts")
    val priceParts: List<TdLabeledPricePart>
) : TdObject

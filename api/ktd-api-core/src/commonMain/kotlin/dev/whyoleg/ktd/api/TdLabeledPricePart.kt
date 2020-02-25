package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Portion of the price of a product (e.g., "delivery cost", "tax amount")
 *
 * @property label Label for this portion of the product price
 * @property amount Currency amount in minimal quantity of the currency
 */
@Serializable
@SerialName("labeledPricePart")
data class TdLabeledPricePart(
    @SerialName("label")
    val label: String,
    @SerialName("amount")
    val amount: Long
) : TdObject

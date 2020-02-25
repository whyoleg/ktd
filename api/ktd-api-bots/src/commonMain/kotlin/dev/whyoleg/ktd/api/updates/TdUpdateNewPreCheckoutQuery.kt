package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * A new incoming pre-checkout query
 * Contains full information about a checkout
 *
 * @property id Unique query identifier
 * @property senderUserId Identifier of the user who sent the query
 * @property currency Currency for the product price
 * @property totalAmount Total price for the product, in the minimal quantity of the currency
 * @property invoicePayload Invoice payload
 * @property shippingOptionId Identifier of a shipping option chosen by the user
 *                            May be empty if not applicable
 * @property orderInfo Information about the order
 */
@Serializable
@SerialName("updateNewPreCheckoutQuery")
data class TdUpdateNewPreCheckoutQuery(
    @SerialName("id")
    val id: Long,
    @SerialName("sender_user_id")
    val senderUserId: Int,
    @SerialName("currency")
    val currency: String,
    @SerialName("total_amount")
    val totalAmount: Long,
    @SerialName("invoice_payload")
    val invoicePayload: ByteArray,
    @SerialName("shipping_option_id")
    val shippingOptionId: String?,
    @SerialName("order_info")
    val orderInfo: TdOrderInfo?
) : TdUpdate

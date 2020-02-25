package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * A new incoming shipping query
 * Only for invoices with flexible price
 *
 * @property id Unique query identifier
 * @property senderUserId Identifier of the user who sent the query
 * @property invoicePayload Invoice payload
 * @property shippingAddress User shipping address
 */
@Serializable
@SerialName("updateNewShippingQuery")
data class TdUpdateNewShippingQuery(
    @SerialName("id")
    val id: Long,
    @SerialName("sender_user_id")
    val senderUserId: Int,
    @SerialName("invoice_payload")
    val invoicePayload: String,
    @SerialName("shipping_address")
    val shippingAddress: TdAddress
) : TdUpdate

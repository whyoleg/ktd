package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a successful payment
 *
 * @property date Point in time (Unix timestamp) when the payment was made
 * @property paymentsProviderUserId User identifier of the payment provider bot
 * @property invoice Contains information about the invoice
 * @property orderInfo Contains order information
 * @property shippingOption Chosen shipping option
 * @property credentialsTitle Title of the saved credentials
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("paymentReceipt")
data class TdPaymentReceipt(
    @SerialName("date")
    val date: Int,
    @SerialName("payments_provider_user_id")
    val paymentsProviderUserId: Int,
    @SerialName("invoice")
    val invoice: TdInvoice,
    @SerialName("order_info")
    val orderInfo: TdOrderInfo?,
    @SerialName("shipping_option")
    val shippingOption: TdShippingOption?,
    @SerialName("credentials_title")
    val credentialsTitle: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

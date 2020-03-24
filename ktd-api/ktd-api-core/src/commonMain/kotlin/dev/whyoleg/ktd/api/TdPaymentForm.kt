package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about an invoice payment form
 *
 * @property invoice Full information of the invoice
 * @property url Payment form URL
 * @property paymentsProvider Contains information about the payment provider, if available, to support it natively without the need for opening the URL
 * @property savedOrderInfo Saved server-side order information
 * @property savedCredentials Contains information about saved card credentials
 * @property canSaveCredentials True, if the user can choose to save credentials
 * @property needPassword True, if the user will be able to save credentials protected by a password they set up
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("paymentForm")
data class TdPaymentForm(
    @SerialName("invoice")
    val invoice: TdInvoice,
    @SerialName("url")
    val url: String,
    @SerialName("payments_provider")
    val paymentsProvider: TdPaymentsProviderStripe?,
    @SerialName("saved_order_info")
    val savedOrderInfo: TdOrderInfo?,
    @SerialName("saved_credentials")
    val savedCredentials: TdSavedCredentials?,
    @SerialName("can_save_credentials")
    val canSaveCredentials: Boolean,
    @SerialName("need_password")
    val needPassword: Boolean,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

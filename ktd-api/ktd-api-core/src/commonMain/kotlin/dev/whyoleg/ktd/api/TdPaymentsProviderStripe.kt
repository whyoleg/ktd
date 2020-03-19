package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Stripe payment provider
 *
 * @property publishableKey Stripe API publishable key
 * @property needCountry True, if the user country must be provided
 * @property needPostalCode True, if the user ZIP/postal code must be provided
 * @property needCardholderName True, if the cardholder name must be provided
 */
@Serializable
@SerialName("paymentsProviderStripe")
data class TdPaymentsProviderStripe(
    @SerialName("publishable_key")
    val publishableKey: String,
    @SerialName("need_country")
    val needCountry: Boolean,
    @SerialName("need_postal_code")
    val needPostalCode: Boolean,
    @SerialName("need_cardholder_name")
    val needCardholderName: Boolean
) : TdObject

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Product invoice
 *
 * @property currency ISO 4217 currency code
 * @property priceParts A list of objects used to calculate the total price of the product
 * @property isTest True, if the payment is a test payment
 * @property needName True, if the user's name is needed for payment
 * @property needPhoneNumber True, if the user's phone number is needed for payment
 * @property needEmailAddress True, if the user's email address is needed for payment
 * @property needShippingAddress True, if the user's shipping address is needed for payment
 * @property sendPhoneNumberToProvider True, if the user's phone number will be sent to the provider
 * @property sendEmailAddressToProvider True, if the user's email address will be sent to the provider
 * @property isFlexible True, if the total price depends on the shipping method
 */
@Serializable
@SerialName("invoice")
data class TdInvoice(
    @SerialName("currency")
    val currency: String,
    @SerialName("price_parts")
    val priceParts: List<TdLabeledPricePart>,
    @SerialName("is_test")
    val isTest: Boolean,
    @SerialName("need_name")
    val needName: Boolean,
    @SerialName("need_phone_number")
    val needPhoneNumber: Boolean,
    @SerialName("need_email_address")
    val needEmailAddress: Boolean,
    @SerialName("need_shipping_address")
    val needShippingAddress: Boolean,
    @SerialName("send_phone_number_to_provider")
    val sendPhoneNumberToProvider: Boolean,
    @SerialName("send_email_address_to_provider")
    val sendEmailAddressToProvider: Boolean,
    @SerialName("is_flexible")
    val isFlexible: Boolean
) : TdObject

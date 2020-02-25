package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes an address
 *
 * @property countryCode A two-letter ISO 3166-1 alpha-2 country code
 * @property state State, if applicable
 * @property city City
 * @property streetLine1 First line of the address
 * @property streetLine2 Second line of the address
 * @property postalCode Address postal code
 */
@Serializable
@SerialName("address")
data class TdAddress(
    @SerialName("country_code")
    val countryCode: String,
    @SerialName("state")
    val state: String,
    @SerialName("city")
    val city: String,
    @SerialName("street_line1")
    val streetLine1: String,
    @SerialName("street_line2")
    val streetLine2: String,
    @SerialName("postal_code")
    val postalCode: String
) : TdObject

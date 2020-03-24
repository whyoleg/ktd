package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a venue
 *
 * @property location Venue location
 *                    As defined by the sender
 * @property title Venue name
 *                 As defined by the sender
 * @property address Venue address
 *                   As defined by the sender
 * @property provider Provider of the venue database
 *                    As defined by the sender
 *                    Currently only "foursquare" needs to be supported
 * @property id Identifier of the venue in the provider database
 *              As defined by the sender
 * @property type Type of the venue in the provider database
 *                As defined by the sender
 */
@Serializable
@SerialName("venue")
data class TdVenue(
    @SerialName("location")
    val location: TdLocation,
    @SerialName("title")
    val title: String,
    @SerialName("address")
    val address: String,
    @SerialName("provider")
    val provider: String,
    @SerialName("id")
    val id: String,
    @SerialName("type")
    val type: String
) : TdObject

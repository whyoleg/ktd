package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a location on planet Earth
 *
 * @property latitude Latitude of the location in degrees
 *                    As defined by the sender
 * @property longitude Longitude of the location, in degrees
 *                     As defined by the sender
 */
@Serializable
@SerialName("location")
data class TdLocation(
    @SerialName("latitude")
    val latitude: Double,
    @SerialName("longitude")
    val longitude: Double
) : TdObject

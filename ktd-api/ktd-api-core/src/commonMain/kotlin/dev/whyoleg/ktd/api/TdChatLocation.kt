package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a location to which a chat is connected
 *
 * @property location The location
 * @property address Location address
 */
@Serializable
@SerialName("chatLocation")
data class TdChatLocation(
    @SerialName("location")
    val location: TdLocation,
    @SerialName("address")
    val address: String
) : TdObject

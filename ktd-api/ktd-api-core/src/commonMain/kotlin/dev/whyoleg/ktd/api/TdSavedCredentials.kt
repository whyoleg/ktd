package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about saved card credentials
 *
 * @property id Unique identifier of the saved credentials
 * @property title Title of the saved credentials
 */
@Serializable
@SerialName("savedCredentials")
data class TdSavedCredentials(
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String
) : TdObject

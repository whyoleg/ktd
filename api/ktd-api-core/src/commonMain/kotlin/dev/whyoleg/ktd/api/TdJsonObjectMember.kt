package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents one member of a JSON object
 *
 * @property key Member's key
 * @property value Member's value
 */
@Serializable
@SerialName("jsonObjectMember")
data class TdJsonObjectMember(
    @SerialName("key")
    val key: String,
    @SerialName("value")
    val value: TdJsonValue
) : TdObject

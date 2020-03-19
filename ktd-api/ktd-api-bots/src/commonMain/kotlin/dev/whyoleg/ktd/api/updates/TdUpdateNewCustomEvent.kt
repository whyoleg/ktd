package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * A new incoming event
 *
 * @property event A JSON-serialized event
 */
@Serializable
@SerialName("updateNewCustomEvent")
data class TdUpdateNewCustomEvent(
    @SerialName("event")
    val event: String
) : TdUpdate

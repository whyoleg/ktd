package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * A new incoming query
 *
 * @property id The query identifier
 * @property data JSON-serialized query data
 * @property timeout Query timeout
 */
@Serializable
@SerialName("updateNewCustomQuery")
data class TdUpdateNewCustomQuery(
    @SerialName("id")
    val id: Long,
    @SerialName("data")
    val data: String,
    @SerialName("timeout")
    val timeout: Int
) : TdUpdate

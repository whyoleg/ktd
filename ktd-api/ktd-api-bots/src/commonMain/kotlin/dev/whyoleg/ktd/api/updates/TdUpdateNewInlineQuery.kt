package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * A new incoming inline query
 *
 * @property id Unique query identifier
 * @property senderUserId Identifier of the user who sent the query
 * @property userLocation User location, provided by the client
 * @property query Text of the query
 * @property offset Offset of the first entry to return
 */
@Serializable
@SerialName("updateNewInlineQuery")
data class TdUpdateNewInlineQuery(
    @SerialName("id")
    val id: Long,
    @SerialName("sender_user_id")
    val senderUserId: Int,
    @SerialName("user_location")
    val userLocation: TdLocation?,
    @SerialName("query")
    val query: String,
    @SerialName("offset")
    val offset: String
) : TdUpdate

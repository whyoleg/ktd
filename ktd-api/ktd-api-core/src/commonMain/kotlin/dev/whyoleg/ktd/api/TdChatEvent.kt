package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a chat event
 *
 * @property id Chat event identifier
 * @property date Point in time (Unix timestamp) when the event happened
 * @property userId Identifier of the user who performed the action that triggered the event
 * @property action Action performed by the user
 */
@Serializable
@SerialName("chatEvent")
data class TdChatEvent(
    @SerialName("id")
    val id: Long,
    @SerialName("date")
    val date: Int,
    @SerialName("user_id")
    val userId: Int,
    @SerialName("action")
    val action: TdChatEventAction
) : TdObject

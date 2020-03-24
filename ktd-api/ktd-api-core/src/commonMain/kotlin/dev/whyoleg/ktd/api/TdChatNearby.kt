package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a chat located nearby
 *
 * @property chatId Chat identifier
 * @property distance Distance to the chat location in meters
 */
@Serializable
@SerialName("chatNearby")
data class TdChatNearby(
    @SerialName("chat_id")
    val chatId: Long,
    @SerialName("distance")
    val distance: Int
) : TdObject

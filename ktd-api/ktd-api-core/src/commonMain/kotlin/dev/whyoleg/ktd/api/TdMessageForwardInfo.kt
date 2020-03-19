package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a forwarded message
 *
 * @property origin Origin of a forwarded message
 * @property date Point in time (Unix timestamp) when the message was originally sent
 * @property fromChatId For messages forwarded to the chat with the current user (Saved Messages) or to the channel's discussion group, the identifier of the chat from which the message was forwarded last time
 *                      0 if unknown
 * @property fromMessageId For messages forwarded to the chat with the current user (Saved Messages) or to the channel's discussion group, the identifier of the original message from which the new message was forwarded last time
 *                         0 if unknown
 */
@Serializable
@SerialName("messageForwardInfo")
data class TdMessageForwardInfo(
    @SerialName("origin")
    val origin: TdMessageForwardOrigin,
    @SerialName("date")
    val date: Int,
    @SerialName("from_chat_id")
    val fromChatId: Long,
    @SerialName("from_message_id")
    val fromMessageId: Long
) : TdObject

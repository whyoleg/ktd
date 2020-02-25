package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about the origin of a forwarded message
 */
@Serializable
sealed class TdMessageForwardOrigin : TdObject {
    /**
     * The message was originally written by a known user
     *
     * @property senderUserId Identifier of the user that originally sent the message
     */
    @Serializable
    @SerialName("messageForwardOriginUser")
    data class User(
        @SerialName("sender_user_id")
        val senderUserId: Int
    ) : TdMessageForwardOrigin()

    /**
     * The message was originally written by a user, which is hidden by their privacy settings
     *
     * @property senderName Name of the sender
     */
    @Serializable
    @SerialName("messageForwardOriginHiddenUser")
    data class HiddenUser(
        @SerialName("sender_name")
        val senderName: String
    ) : TdMessageForwardOrigin()

    /**
     * The message was originally a post in a channel
     *
     * @property chatId Identifier of the chat from which the message was originally forwarded
     * @property messageId Message identifier of the original message
     *                     0 if unknown
     * @property authorSignature Original post author signature
     */
    @Serializable
    @SerialName("messageForwardOriginChannel")
    data class Channel(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("author_signature")
        val authorSignature: String
    ) : TdMessageForwardOrigin()
}

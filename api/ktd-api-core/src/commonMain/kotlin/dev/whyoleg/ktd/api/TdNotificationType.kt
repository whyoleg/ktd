package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains detailed information about a notification
 */
@Serializable
sealed class TdNotificationType : TdObject {
    /**
     * New message was received
     *
     * @property message The message
     */
    @Serializable
    @SerialName("notificationTypeNewMessage")
    data class NewMessage(
        @SerialName("message")
        val message: TdMessage
    ) : TdNotificationType()

    /**
     * New secret chat was created
     */
    @Serializable
    @SerialName("notificationTypeNewSecretChat")
    object NewSecretChat : TdNotificationType()

    /**
     * New call was received
     *
     * @property callId Call identifier
     */
    @Serializable
    @SerialName("notificationTypeNewCall")
    data class NewCall(
        @SerialName("call_id")
        val callId: Int
    ) : TdNotificationType()

    /**
     * New message was received through a push notification
     *
     * @property messageId The message identifier
     *                     The message will not be available in the chat history, but the ID can be used in viewMessages and as reply_to_message_id
     * @property senderUserId Sender of the message
     *                        Corresponding user may be inaccessible
     * @property content Push message content
     */
    @Serializable
    @SerialName("notificationTypeNewPushMessage")
    data class NewPushMessage(
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("sender_user_id")
        val senderUserId: Int,
        @SerialName("content")
        val content: TdPushMessageContent
    ) : TdNotificationType()
}

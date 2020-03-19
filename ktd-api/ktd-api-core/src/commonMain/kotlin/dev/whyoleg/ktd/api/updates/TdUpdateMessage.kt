package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

@Serializable
sealed class TdUpdateMessage : TdUpdate {
    /**
     * A new message was received
     * Can also be an outgoing message
     *
     * @property message The new message
     */
    @Serializable
    @SerialName("updateNewMessage")
    data class Data(
        @SerialName("message")
        val message: TdMessage
    ) : TdUpdateMessage()

    /**
     * A request to send a message has reached the Telegram server
     * This doesn't mean that the message will be sent successfully or even that the send message request will be processed
     * This update will be sent only if the option "use_quick_ack" is set to true
     * This update may be sent multiple times for the same message
     *
     * @property chatId The chat identifier of the sent message
     * @property messageId A temporary message identifier
     */
    @Serializable
    @SerialName("updateMessageSendAcknowledged")
    data class SendAcknowledged(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long
    ) : TdUpdateMessage()

    /**
     * A message has been successfully sent
     *
     * @property message Information about the sent message
     *                   Usually only the message identifier, date, and content are changed, but almost all other fields can also change
     * @property oldMessageId The previous temporary message identifier
     */
    @Serializable
    @SerialName("updateMessageSendSucceeded")
    data class SendSucceeded(
        @SerialName("message")
        val message: TdMessage,
        @SerialName("old_message_id")
        val oldMessageId: Long
    ) : TdUpdateMessage()

    /**
     * A message failed to send
     * Be aware that some messages being sent can be irrecoverably deleted, in which case updateDeleteMessages will be received instead of this update
     *
     * @property message Contains information about the message which failed to send
     * @property oldMessageId The previous temporary message identifier
     * @property errorCode An error code
     * @property errorMessage Error message
     */
    @Serializable
    @SerialName("updateMessageSendFailed")
    data class SendFailed(
        @SerialName("message")
        val message: TdMessage,
        @SerialName("old_message_id")
        val oldMessageId: Long,
        @SerialName("error_code")
        val errorCode: Int,
        @SerialName("error_message")
        val errorMessage: String
    ) : TdUpdateMessage()

    /**
     * The message content has changed
     *
     * @property chatId Chat identifier
     * @property messageId Message identifier
     * @property newContent New message content
     */
    @Serializable
    @SerialName("updateMessageContent")
    data class Content(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("new_content")
        val newContent: TdMessageContent
    ) : TdUpdateMessage()

    /**
     * A message was edited
     * Changes in the message content will come in a separate updateMessageContent
     *
     * @property chatId Chat identifier
     * @property messageId Message identifier
     * @property editDate Point in time (Unix timestamp) when the message was edited
     * @property replyMarkup New message reply markup
     */
    @Serializable
    @SerialName("updateMessageEdited")
    data class Edited(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("edit_date")
        val editDate: Int,
        @SerialName("reply_markup")
        val replyMarkup: TdReplyMarkup?
    ) : TdUpdateMessage()

    /**
     * The view count of the message has changed
     *
     * @property chatId Chat identifier
     * @property messageId Message identifier
     * @property views New value of the view count
     */
    @Serializable
    @SerialName("updateMessageViews")
    data class Views(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("views")
        val views: Int
    ) : TdUpdateMessage()

    /**
     * The message content was opened
     * Updates voice note messages to "listened", video note messages to "viewed" and starts the TTL timer for self-destructing messages
     *
     * @property chatId Chat identifier
     * @property messageId Message identifier
     */
    @Serializable
    @SerialName("updateMessageContentOpened")
    data class ContentOpened(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long
    ) : TdUpdateMessage()

    /**
     * A message with an unread mention was read
     *
     * @property chatId Chat identifier
     * @property messageId Message identifier
     * @property unreadMentionCount The new number of unread mention messages left in the chat
     */
    @Serializable
    @SerialName("updateMessageMentionRead")
    data class MentionRead(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("unread_mention_count")
        val unreadMentionCount: Int
    ) : TdUpdateMessage()

    /**
     * A message with a live location was viewed
     * When the update is received, the client is supposed to update the live location
     *
     * @property chatId Identifier of the chat with the live location message
     * @property messageId Identifier of the message with live location
     */
    @Serializable
    @SerialName("updateMessageLiveLocationViewed")
    data class LiveLocationViewed(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long
    ) : TdUpdateMessage()
}

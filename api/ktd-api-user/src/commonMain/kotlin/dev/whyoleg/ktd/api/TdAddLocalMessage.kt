package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds a local message to a chat
 * The message is persistent across application restarts only if the message database is used
 * Returns the added message
 *
 * @property chatId Target chat
 * @property senderUserId Identifier of the user who will be shown as the sender of the message
 *                        May be 0 for channel posts
 * @property replyToMessageId Identifier of the message to reply to or 0
 * @property disableNotification Pass true to disable notification for the message
 * @property inputMessageContent The content of the message to be added
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("addLocalMessage")
data class TdAddLocalMessage(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("sender_user_id")
    val senderUserId: Int = 0,
    @SerialName("reply_to_message_id")
    val replyToMessageId: Long = 0L,
    @SerialName("disable_notification")
    val disableNotification: Boolean = false,
    @SerialName("input_message_content")
    val inputMessageContent: TdInputMessageContent? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAddLocalMessage {
        return copy(extra = extra.copy(id = id))
    }
}

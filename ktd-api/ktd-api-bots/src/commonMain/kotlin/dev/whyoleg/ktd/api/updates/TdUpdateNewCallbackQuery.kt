package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * A new incoming callback query
 *
 * @property id Unique query identifier
 * @property senderUserId Identifier of the user who sent the query
 * @property chatId Identifier of the chat where the query was sent
 * @property messageId Identifier of the message, from which the query originated
 * @property chatInstance Identifier that uniquely corresponds to the chat to which the message was sent
 * @property payload Query payload
 */
@Serializable
@SerialName("updateNewCallbackQuery")
data class TdUpdateNewCallbackQuery(
    @SerialName("id")
    val id: Long,
    @SerialName("sender_user_id")
    val senderUserId: Int,
    @SerialName("chat_id")
    val chatId: Long,
    @SerialName("message_id")
    val messageId: Long,
    @SerialName("chat_instance")
    val chatInstance: Long,
    @SerialName("payload")
    val payload: TdCallbackQueryPayload
) : TdUpdate

package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * A new incoming callback query from a message sent via a bot
 *
 * @property id Unique query identifier
 * @property senderUserId Identifier of the user who sent the query
 * @property inlineMessageId Identifier of the inline message, from which the query originated
 * @property chatInstance An identifier uniquely corresponding to the chat a message was sent to
 * @property payload Query payload
 */
@Serializable
@SerialName("updateNewInlineCallbackQuery")
data class TdUpdateNewInlineCallbackQuery(
    @SerialName("id")
    val id: Long,
    @SerialName("sender_user_id")
    val senderUserId: Int,
    @SerialName("inline_message_id")
    val inlineMessageId: String,
    @SerialName("chat_instance")
    val chatInstance: Long,
    @SerialName("payload")
    val payload: TdCallbackQueryPayload
) : TdUpdate

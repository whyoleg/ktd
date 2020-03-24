package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a message draft
 *
 * @property replyToMessageId Identifier of the message to reply to
 *                            0 if none
 * @property inputMessageText Content of the message draft
 *                            This should always be of type inputMessageText
 */
@Serializable
@SerialName("draftMessage")
data class TdDraftMessage(
    @SerialName("reply_to_message_id")
    val replyToMessageId: Long,
    @SerialName("input_message_text")
    val inputMessageText: TdInputMessageContent
) : TdObject

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends messages grouped together into an album
 * Currently only photo and video messages can be grouped into an album
 * Returns sent messages
 *
 * @property chatId Target chat
 * @property replyToMessageId Identifier of a message to reply to or 0
 * @property options Options to be used to send the messages
 * @property inputMessageContents Contents of messages to be sent
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendMessageAlbum")
data class TdSendMessageAlbum(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("reply_to_message_id")
    val replyToMessageId: Long = 0L,
    @SerialName("options")
    val options: TdSendMessageOptions? = null,
    @SerialName("input_message_contents")
    val inputMessageContents: List<TdInputMessageContent> = emptyList(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessages> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendMessageAlbum {
        return copy(extra = extra.copy(id = id))
    }
}

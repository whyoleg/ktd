package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends the result of an inline query as a message
 * Returns the sent message
 * Always clears a chat draft message
 *
 * @property chatId Target chat
 * @property replyToMessageId Identifier of a message to reply to or 0
 * @property options Options to be used to send the message
 * @property queryId Identifier of the inline query
 * @property resultId Identifier of the inline result
 * @property hideViaBot If true, there will be no mention of a bot, via which the message is sent
 *                      Can be used only for bots GetOption("animation_search_bot_username"), GetOption("photo_search_bot_username") and GetOption("venue_search_bot_username")
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendInlineQueryResultMessage")
data class TdSendInlineQueryResultMessage(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("reply_to_message_id")
    val replyToMessageId: Long = 0L,
    @SerialName("options")
    val options: TdSendMessageOptions? = null,
    @SerialName("query_id")
    val queryId: Long = 0L,
    @SerialName("result_id")
    val resultId: String? = null,
    @SerialName("hide_via_bot")
    val hideViaBot: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendInlineQueryResultMessage {
        return copy(extra = extra.copy(id = id))
    }
}

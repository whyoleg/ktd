package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns messages in a chat
 * The messages are returned in a reverse chronological order (i.e., in order of decreasing message_id)
 * For optimal performance the number of returned messages is chosen by the library
 * This is an offline request if only_local is true
 *
 * @property chatId Chat identifier
 * @property fromMessageId Identifier of the message starting from which history must be fetched
 *                         Use 0 to get results from the last message
 * @property offset Specify 0 to get results from exactly the from_message_id or a negative offset up to 99 to get additionally some newer messages
 * @property limit The maximum number of messages to be returned
 *                 Must be positive and can't be greater than 100
 *                 If the offset is negative, the limit must be greater or equal to -offset
 *                 Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @property onlyLocal If true, returns only messages that are available locally without sending network requests
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getChatHistory")
data class TdGetChatHistory(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("from_message_id")
    val fromMessageId: Long = 0L,
    @SerialName("offset")
    val offset: Int = 0,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("only_local")
    val onlyLocal: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessages> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetChatHistory {
        return copy(extra = extra.copy(id = id))
    }
}

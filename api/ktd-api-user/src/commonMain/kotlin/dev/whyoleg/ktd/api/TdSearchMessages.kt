package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for messages in all chats except secret chats
 * Returns the results in reverse chronological order (i.e., in order of decreasing (date, chat_id, message_id))
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @property chatList Chat list in which to search messages
 *                    Pass null to search in all chats regardless of their chat list
 * @property query Query to search for
 * @property offsetDate The date of the message starting from which the results should be fetched
 *                      Use 0 or any date in the future to get results from the last message
 * @property offsetChatId The chat identifier of the last found message, or 0 for the first request
 * @property offsetMessageId The message identifier of the last found message, or 0 for the first request
 * @property limit The maximum number of messages to be returned, up to 100
 *                 Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchMessages")
data class TdSearchMessages(
    @SerialName("chat_list")
    val chatList: TdChatList? = null,
    @SerialName("query")
    val query: String? = null,
    @SerialName("offset_date")
    val offsetDate: Int = 0,
    @SerialName("offset_chat_id")
    val offsetChatId: Long = 0L,
    @SerialName("offset_message_id")
    val offsetMessageId: Long = 0L,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessages> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchMessages {
        return copy(extra = extra.copy(id = id))
    }
}

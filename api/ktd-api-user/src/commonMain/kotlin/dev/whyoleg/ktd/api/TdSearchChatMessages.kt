package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for messages with given words in the chat
 * Returns the results in reverse chronological order, i.e
 * In order of decreasing message_id
 * Cannot be used in secret chats with a non-empty query (searchSecretMessages should be used instead), or without an enabled message database
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @property chatId Identifier of the chat in which to search messages
 * @property query Query to search for
 * @property senderUserId If not 0, only messages sent by the specified user will be returned
 *                        Not supported in secret chats
 * @property fromMessageId Identifier of the message starting from which history must be fetched
 *                         Use 0 to get results from the last message
 * @property offset Specify 0 to get results from exactly the from_message_id or a negative offset to get the specified message and some newer messages
 * @property limit The maximum number of messages to be returned
 *                 Must be positive and can't be greater than 100
 *                 If the offset is negative, the limit must be greater than -offset
 *                 Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @property filter Filter for message content in the search results
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchChatMessages")
data class TdSearchChatMessages(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("query")
    val query: String? = null,
    @SerialName("sender_user_id")
    val senderUserId: Int = 0,
    @SerialName("from_message_id")
    val fromMessageId: Long = 0L,
    @SerialName("offset")
    val offset: Int = 0,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("filter")
    val filter: TdSearchMessagesFilter? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessages> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchChatMessages {
        return copy(extra = extra.copy(id = id))
    }
}

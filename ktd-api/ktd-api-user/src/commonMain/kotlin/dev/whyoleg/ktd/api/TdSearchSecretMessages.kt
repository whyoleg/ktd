package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for messages in secret chats
 * Returns the results in reverse chronological order
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @property chatId Identifier of the chat in which to search
 *                  Specify 0 to search in all secret chats
 * @property query Query to search for
 *                 If empty, searchChatMessages should be used instead
 * @property fromSearchId The identifier from the result of a previous request, use 0 to get results from the last message
 * @property limit The maximum number of messages to be returned
 *                 Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @property filter A filter for the content of messages in the search results
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchSecretMessages")
data class TdSearchSecretMessages(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("query")
    val query: String? = null,
    @SerialName("from_search_id")
    val fromSearchId: Long = 0L,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("filter")
    val filter: TdSearchMessagesFilter? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdFoundMessages> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchSecretMessages {
        return copy(extra = extra.copy(id = id))
    }
}

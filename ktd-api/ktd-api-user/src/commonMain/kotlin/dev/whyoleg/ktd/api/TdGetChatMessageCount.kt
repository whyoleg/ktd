package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns approximate number of messages of the specified type in the chat
 *
 * @property chatId Identifier of the chat in which to count messages
 * @property filter Filter for message content
 *                  SearchMessagesFilterEmpty is unsupported in this function
 * @property returnLocal If true, returns count that is available locally without sending network requests, returning -1 if the number of messages is unknown
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getChatMessageCount")
data class TdGetChatMessageCount(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("filter")
    val filter: TdSearchMessagesFilter? = null,
    @SerialName("return_local")
    val returnLocal: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdCount> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetChatMessageCount {
        return copy(extra = extra.copy(id = id))
    }
}

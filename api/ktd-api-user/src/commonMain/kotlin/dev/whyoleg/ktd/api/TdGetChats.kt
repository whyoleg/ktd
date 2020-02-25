package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns an ordered list of chats in a chat list
 * Chats are sorted by the pair (order, chat_id) in decreasing order
 * (For example, to get a list of chats from the beginning, the offset_order should be equal to a biggest signed 64-bit number 9223372036854775807 == 2^63 - 1)
 * For optimal performance the number of returned chats is chosen by the library
 *
 * @property chatList The chat list in which to return chats
 * @property offsetOrder Chat order to return chats from
 * @property offsetChatId Chat identifier to return chats from
 * @property limit The maximum number of chats to be returned
 *                 It is possible that fewer chats than the limit are returned even if the end of the list is not reached
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getChats")
data class TdGetChats(
    @SerialName("chat_list")
    val chatList: TdChatList? = null,
    @SerialName("offset_order")
    val offsetOrder: Long = 0L,
    @SerialName("offset_chat_id")
    val offsetChatId: Long = 0L,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChats> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetChats {
        return copy(extra = extra.copy(id = id))
    }
}

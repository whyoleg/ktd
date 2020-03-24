package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

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
suspend fun SuspendTdClient.getChats(
    chatList: TdChatList? = null,
    offsetOrder: Long = 0L,
    offsetChatId: Long = 0L,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdChats = exec(TdGetChats(chatList, offsetOrder, offsetChatId, limit, extra))

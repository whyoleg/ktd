package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the order of pinned chats
 *
 * @property chatList Chat list in which to change the order of pinned chats
 * @property chatIds The new list of pinned chats
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setPinnedChats")
data class TdSetPinnedChats(
    @SerialName("chat_list")
    val chatList: TdChatList? = null,
    @SerialName("chat_ids")
    val chatIds: LongArray = longArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetPinnedChats {
        return copy(extra = extra.copy(id = id))
    }
}

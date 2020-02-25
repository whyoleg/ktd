package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Moves a chat to a different chat list
 * Current chat list of the chat must ne non-null
 *
 * @property chatId Chat identifier
 * @property chatList New chat list of the chat
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setChatChatList")
data class TdSetChatChatList(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("chat_list")
    val chatList: TdChatList? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetChatChatList {
        return copy(extra = extra.copy(id = id))
    }
}

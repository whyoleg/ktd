package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

@Serializable
sealed class TdUpdateUnread : TdUpdate {
    /**
     * Number of unread messages in a chat list has changed
     * This update is sent only if the message database is used
     *
     * @property chatList The chat list with changed number of unread messages
     * @property unreadCount Total number of unread messages
     * @property unreadUnmutedCount Total number of unread messages in unmuted chats
     */
    @Serializable
    @SerialName("updateUnreadMessageCount")
    data class MessageCount(
        @SerialName("chat_list")
        val chatList: TdChatList,
        @SerialName("unread_count")
        val unreadCount: Int,
        @SerialName("unread_unmuted_count")
        val unreadUnmutedCount: Int
    ) : TdUpdateUnread()

    /**
     * Number of unread chats, i.e
     * With unread messages or marked as unread, has changed
     * This update is sent only if the message database is used
     *
     * @property chatList The chat list with changed number of unread messages
     * @property totalCount Approximate total number of chats in the chat list
     * @property unreadCount Total number of unread chats
     * @property unreadUnmutedCount Total number of unread unmuted chats
     * @property markedAsUnreadCount Total number of chats marked as unread
     * @property markedAsUnreadUnmutedCount Total number of unmuted chats marked as unread
     */
    @Serializable
    @SerialName("updateUnreadChatCount")
    data class ChatCount(
        @SerialName("chat_list")
        val chatList: TdChatList,
        @SerialName("total_count")
        val totalCount: Int,
        @SerialName("unread_count")
        val unreadCount: Int,
        @SerialName("unread_unmuted_count")
        val unreadUnmutedCount: Int,
        @SerialName("marked_as_unread_count")
        val markedAsUnreadCount: Int,
        @SerialName("marked_as_unread_unmuted_count")
        val markedAsUnreadUnmutedCount: Int
    ) : TdUpdateUnread()
}

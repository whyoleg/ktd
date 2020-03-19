package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

@Serializable
sealed class TdUpdateChat : TdUpdate {
    /**
     * A new chat has been loaded/created
     * This update is guaranteed to come before the chat identifier is returned to the client
     * The chat field changes will be reported through separate updates
     *
     * @property chat The chat
     */
    @Serializable
    @SerialName("updateNewChat")
    data class Data(
        @SerialName("chat")
        val chat: TdChat
    ) : TdUpdateChat()

    /**
     * The list to which the chat belongs was changed
     * This update is guaranteed to be sent only when chat.order == 0 and the current or the new chat list is null
     *
     * @property chatId Chat identifier
     * @property chatList The new chat's chat list
     */
    @Serializable
    @SerialName("updateChatChatList")
    data class ChatList(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("chat_list")
        val chatList: TdChatList?
    ) : TdUpdateChat()

    /**
     * The title of a chat was changed
     *
     * @property chatId Chat identifier
     * @property title The new chat title
     */
    @Serializable
    @SerialName("updateChatTitle")
    data class Title(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("title")
        val title: String
    ) : TdUpdateChat()

    /**
     * A chat photo was changed
     *
     * @property chatId Chat identifier
     * @property photo The new chat photo
     */
    @Serializable
    @SerialName("updateChatPhoto")
    data class Photo(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("photo")
        val photo: TdChatPhoto?
    ) : TdUpdateChat()

    /**
     * Chat permissions was changed
     *
     * @property chatId Chat identifier
     * @property permissions The new chat permissions
     */
    @Serializable
    @SerialName("updateChatPermissions")
    data class Permissions(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("permissions")
        val permissions: TdChatPermissions
    ) : TdUpdateChat()

    /**
     * The last message of a chat was changed
     * If last_message is null, then the last message in the chat became unknown
     * Some new unknown messages might be added to the chat in this case
     *
     * @property chatId Chat identifier
     * @property lastMessage The new last message in the chat
     * @property order New value of the chat order
     */
    @Serializable
    @SerialName("updateChatLastMessage")
    data class LastMessage(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("last_message")
        val lastMessage: TdMessage?,
        @SerialName("order")
        val order: Long
    ) : TdUpdateChat()

    /**
     * The order of the chat in the chat list has changed
     * Instead of this update updateChatLastMessage, updateChatIsPinned, updateChatDraftMessage, or updateChatIsSponsored might be sent
     *
     * @property chatId Chat identifier
     * @property order New value of the order
     */
    @Serializable
    @SerialName("updateChatOrder")
    data class Order(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("order")
        val order: Long
    ) : TdUpdateChat()

    /**
     * A chat was pinned or unpinned
     *
     * @property chatId Chat identifier
     * @property isPinned New value of is_pinned
     * @property order New value of the chat order
     */
    @Serializable
    @SerialName("updateChatIsPinned")
    data class IsPinned(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("is_pinned")
        val isPinned: Boolean,
        @SerialName("order")
        val order: Long
    ) : TdUpdateChat()

    /**
     * A chat was marked as unread or was read
     *
     * @property chatId Chat identifier
     * @property isMarkedAsUnread New value of is_marked_as_unread
     */
    @Serializable
    @SerialName("updateChatIsMarkedAsUnread")
    data class IsMarkedAsUnread(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("is_marked_as_unread")
        val isMarkedAsUnread: Boolean
    ) : TdUpdateChat()

    /**
     * A chat's is_sponsored field has changed
     *
     * @property chatId Chat identifier
     * @property isSponsored New value of is_sponsored
     * @property order New value of chat order
     */
    @Serializable
    @SerialName("updateChatIsSponsored")
    data class IsSponsored(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("is_sponsored")
        val isSponsored: Boolean,
        @SerialName("order")
        val order: Long
    ) : TdUpdateChat()

    /**
     * A chat's has_scheduled_messages field has changed
     *
     * @property chatId Chat identifier
     * @property hasScheduledMessages New value of has_scheduled_messages
     */
    @Serializable
    @SerialName("updateChatHasScheduledMessages")
    data class HasScheduledMessages(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("has_scheduled_messages")
        val hasScheduledMessages: Boolean
    ) : TdUpdateChat()

    /**
     * The value of the default disable_notification parameter, used when a message is sent to the chat, was changed
     *
     * @property chatId Chat identifier
     * @property defaultDisableNotification The new default_disable_notification value
     */
    @Serializable
    @SerialName("updateChatDefaultDisableNotification")
    data class DefaultDisableNotification(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("default_disable_notification")
        val defaultDisableNotification: Boolean
    ) : TdUpdateChat()

    /**
     * Incoming messages were read or number of unread messages has been changed
     *
     * @property chatId Chat identifier
     * @property lastReadInboxMessageId Identifier of the last read incoming message
     * @property unreadCount The number of unread messages left in the chat
     */
    @Serializable
    @SerialName("updateChatReadInbox")
    data class ReadInbox(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("last_read_inbox_message_id")
        val lastReadInboxMessageId: Long,
        @SerialName("unread_count")
        val unreadCount: Int
    ) : TdUpdateChat()

    /**
     * Outgoing messages were read
     *
     * @property chatId Chat identifier
     * @property lastReadOutboxMessageId Identifier of last read outgoing message
     */
    @Serializable
    @SerialName("updateChatReadOutbox")
    data class ReadOutbox(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("last_read_outbox_message_id")
        val lastReadOutboxMessageId: Long
    ) : TdUpdateChat()

    /**
     * The chat unread_mention_count has changed
     *
     * @property chatId Chat identifier
     * @property unreadMentionCount The number of unread mention messages left in the chat
     */
    @Serializable
    @SerialName("updateChatUnreadMentionCount")
    data class UnreadMentionCount(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("unread_mention_count")
        val unreadMentionCount: Int
    ) : TdUpdateChat()

    /**
     * Notification settings for a chat were changed
     *
     * @property chatId Chat identifier
     * @property notificationSettings The new notification settings
     */
    @Serializable
    @SerialName("updateChatNotificationSettings")
    data class NotificationSettings(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("notification_settings")
        val notificationSettings: TdChatNotificationSettings
    ) : TdUpdateChat()

    /**
     * The chat action bar was changed
     *
     * @property chatId Chat identifier
     * @property actionBar The new value of the action bar
     */
    @Serializable
    @SerialName("updateChatActionBar")
    data class ActionBar(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("action_bar")
        val actionBar: TdChatActionBar?
    ) : TdUpdateChat()

    /**
     * The chat pinned message was changed
     *
     * @property chatId Chat identifier
     * @property pinnedMessageId The new identifier of the pinned message
     *                           0 if there is no pinned message in the chat
     */
    @Serializable
    @SerialName("updateChatPinnedMessage")
    data class PinnedMessage(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("pinned_message_id")
        val pinnedMessageId: Long
    ) : TdUpdateChat()

    /**
     * The default chat reply markup was changed
     * Can occur because new messages with reply markup were received or because an old reply markup was hidden by the user
     *
     * @property chatId Chat identifier
     * @property replyMarkupMessageId Identifier of the message from which reply markup needs to be used
     *                                0 if there is no default custom reply markup in the chat
     */
    @Serializable
    @SerialName("updateChatReplyMarkup")
    data class ReplyMarkup(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("reply_markup_message_id")
        val replyMarkupMessageId: Long
    ) : TdUpdateChat()

    /**
     * A chat draft has changed
     * Be aware that the update may come in the currently opened chat but with old content of the draft
     * If the user has changed the content of the draft, this update shouldn't be applied
     *
     * @property chatId Chat identifier
     * @property draftMessage The new draft message
     * @property order New value of the chat order
     */
    @Serializable
    @SerialName("updateChatDraftMessage")
    data class DraftMessage(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("draft_message")
        val draftMessage: TdDraftMessage?,
        @SerialName("order")
        val order: Long
    ) : TdUpdateChat()

    /**
     * The number of online group members has changed
     * This update with non-zero count is sent only for currently opened chats
     * There is no guarantee that it will be sent just after the count has changed
     *
     * @property chatId Identifier of the chat
     * @property onlineMemberCount New number of online members in the chat, or 0 if unknown
     */
    @Serializable
    @SerialName("updateChatOnlineMemberCount")
    data class OnlineMemberCount(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("online_member_count")
        val onlineMemberCount: Int
    ) : TdUpdateChat()
}

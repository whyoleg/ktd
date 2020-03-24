package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A chat
 * (Can be a private chat, basic group, supergroup, or secret chat)
 *
 * @property id Chat unique identifier
 * @property type Type of the chat
 * @property chatList A chat list to which the chat belongs
 * @property title Chat title
 * @property photo Chat photo
 * @property permissions Actions that non-administrator chat members are allowed to take in the chat
 * @property lastMessage Last message in the chat
 * @property order Descending parameter by which chats are sorted in the main chat list
 *                 If the order number of two chats is the same, they must be sorted in descending order by ID
 *                 If 0, the position of the chat in the list is undetermined
 * @property isPinned True, if the chat is pinned
 * @property isMarkedAsUnread True, if the chat is marked as unread
 * @property isSponsored True, if the chat is sponsored by the user's MTProxy server
 * @property hasScheduledMessages True, if the chat has scheduled messages
 * @property canBeDeletedOnlyForSelf True, if the chat messages can be deleted only for the current user while other users will continue to see the messages
 * @property canBeDeletedForAllUsers True, if the chat messages can be deleted for all users
 * @property canBeReported True, if the chat can be reported to Telegram moderators through reportChat
 * @property defaultDisableNotification Default value of the disable_notification parameter, used when a message is sent to the chat
 * @property unreadCount Number of unread messages in the chat
 * @property lastReadInboxMessageId Identifier of the last read incoming message
 * @property lastReadOutboxMessageId Identifier of the last read outgoing message
 * @property unreadMentionCount Number of unread messages with a mention/reply in the chat
 * @property notificationSettings Notification settings for this chat
 * @property actionBar Describes actions which should be possible to do through a chat action bar
 * @property pinnedMessageId Identifier of the pinned message in the chat
 *                           0 if none
 * @property replyMarkupMessageId Identifier of the message from which reply markup needs to be used
 *                                0 if there is no default custom reply markup in the chat
 * @property draftMessage A draft of a message in the chat
 * @property clientData Contains client-specific data associated with the chat
 *                      (For example, the chat position or local chat notification settings can be stored here.) Persistent if the message database is used
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("chat")
data class TdChat(
    @SerialName("id")
    val id: Long,
    @SerialName("type")
    val type: TdChatType,
    @SerialName("chat_list")
    val chatList: TdChatList?,
    @SerialName("title")
    val title: String,
    @SerialName("photo")
    val photo: TdChatPhoto?,
    @SerialName("permissions")
    val permissions: TdChatPermissions,
    @SerialName("last_message")
    val lastMessage: TdMessage?,
    @SerialName("order")
    val order: Long,
    @SerialName("is_pinned")
    val isPinned: Boolean,
    @SerialName("is_marked_as_unread")
    val isMarkedAsUnread: Boolean,
    @SerialName("is_sponsored")
    val isSponsored: Boolean,
    @SerialName("has_scheduled_messages")
    val hasScheduledMessages: Boolean,
    @SerialName("can_be_deleted_only_for_self")
    val canBeDeletedOnlyForSelf: Boolean,
    @SerialName("can_be_deleted_for_all_users")
    val canBeDeletedForAllUsers: Boolean,
    @SerialName("can_be_reported")
    val canBeReported: Boolean,
    @SerialName("default_disable_notification")
    val defaultDisableNotification: Boolean,
    @SerialName("unread_count")
    val unreadCount: Int,
    @SerialName("last_read_inbox_message_id")
    val lastReadInboxMessageId: Long,
    @SerialName("last_read_outbox_message_id")
    val lastReadOutboxMessageId: Long,
    @SerialName("unread_mention_count")
    val unreadMentionCount: Int,
    @SerialName("notification_settings")
    val notificationSettings: TdChatNotificationSettings,
    @SerialName("action_bar")
    val actionBar: TdChatActionBar?,
    @SerialName("pinned_message_id")
    val pinnedMessageId: Long,
    @SerialName("reply_markup_message_id")
    val replyMarkupMessageId: Long,
    @SerialName("draft_message")
    val draftMessage: TdDraftMessage?,
    @SerialName("client_data")
    val clientData: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

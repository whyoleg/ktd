package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a chat event
 */
@Serializable
sealed class TdChatEventAction : TdObject {
    /**
     * A message was edited
     *
     * @property oldMessage The original message before the edit
     * @property newMessage The message after it was edited
     */
    @Serializable
    @SerialName("chatEventMessageEdited")
    data class ChatEventMessageEdited(
        @SerialName("old_message")
        val oldMessage: TdMessage,
        @SerialName("new_message")
        val newMessage: TdMessage
    ) : TdChatEventAction()

    /**
     * A message was deleted
     *
     * @property message Deleted message
     */
    @Serializable
    @SerialName("chatEventMessageDeleted")
    data class ChatEventMessageDeleted(
        @SerialName("message")
        val message: TdMessage
    ) : TdChatEventAction()

    /**
     * A poll in a message was stopped
     *
     * @property message The message with the poll
     */
    @Serializable
    @SerialName("chatEventPollStopped")
    data class ChatEventPollStopped(
        @SerialName("message")
        val message: TdMessage
    ) : TdChatEventAction()

    /**
     * A message was pinned
     *
     * @property message Pinned message
     */
    @Serializable
    @SerialName("chatEventMessagePinned")
    data class ChatEventMessagePinned(
        @SerialName("message")
        val message: TdMessage
    ) : TdChatEventAction()

    /**
     * A message was unpinned
     */
    @Serializable
    @SerialName("chatEventMessageUnpinned")
    object ChatEventMessageUnpinned : TdChatEventAction()

    /**
     * A new member joined the chat
     */
    @Serializable
    @SerialName("chatEventMemberJoined")
    object ChatEventMemberJoined : TdChatEventAction()

    /**
     * A member left the chat
     */
    @Serializable
    @SerialName("chatEventMemberLeft")
    object ChatEventMemberLeft : TdChatEventAction()

    /**
     * A new chat member was invited
     *
     * @property userId New member user identifier
     * @property status New member status
     */
    @Serializable
    @SerialName("chatEventMemberInvited")
    data class ChatEventMemberInvited(
        @SerialName("user_id")
        val userId: Int,
        @SerialName("status")
        val status: TdChatMemberStatus
    ) : TdChatEventAction()

    /**
     * A chat member has gained/lost administrator status, or the list of their administrator privileges has changed
     *
     * @property userId Chat member user identifier
     * @property oldStatus Previous status of the chat member
     * @property newStatus New status of the chat member
     */
    @Serializable
    @SerialName("chatEventMemberPromoted")
    data class ChatEventMemberPromoted(
        @SerialName("user_id")
        val userId: Int,
        @SerialName("old_status")
        val oldStatus: TdChatMemberStatus,
        @SerialName("new_status")
        val newStatus: TdChatMemberStatus
    ) : TdChatEventAction()

    /**
     * A chat member was restricted/unrestricted or banned/unbanned, or the list of their restrictions has changed
     *
     * @property userId Chat member user identifier
     * @property oldStatus Previous status of the chat member
     * @property newStatus New status of the chat member
     */
    @Serializable
    @SerialName("chatEventMemberRestricted")
    data class ChatEventMemberRestricted(
        @SerialName("user_id")
        val userId: Int,
        @SerialName("old_status")
        val oldStatus: TdChatMemberStatus,
        @SerialName("new_status")
        val newStatus: TdChatMemberStatus
    ) : TdChatEventAction()

    /**
     * The chat title was changed
     *
     * @property oldTitle Previous chat title
     * @property newTitle New chat title
     */
    @Serializable
    @SerialName("chatEventTitleChanged")
    data class ChatEventTitleChanged(
        @SerialName("old_title")
        val oldTitle: String,
        @SerialName("new_title")
        val newTitle: String
    ) : TdChatEventAction()

    /**
     * The chat permissions was changed
     *
     * @property oldPermissions Previous chat permissions
     * @property newPermissions New chat permissions
     */
    @Serializable
    @SerialName("chatEventPermissionsChanged")
    data class ChatEventPermissionsChanged(
        @SerialName("old_permissions")
        val oldPermissions: TdChatPermissions,
        @SerialName("new_permissions")
        val newPermissions: TdChatPermissions
    ) : TdChatEventAction()

    /**
     * The chat description was changed
     *
     * @property oldDescription Previous chat description
     * @property newDescription New chat description
     */
    @Serializable
    @SerialName("chatEventDescriptionChanged")
    data class ChatEventDescriptionChanged(
        @SerialName("old_description")
        val oldDescription: String,
        @SerialName("new_description")
        val newDescription: String
    ) : TdChatEventAction()

    /**
     * The chat username was changed
     *
     * @property oldUsername Previous chat username
     * @property newUsername New chat username
     */
    @Serializable
    @SerialName("chatEventUsernameChanged")
    data class ChatEventUsernameChanged(
        @SerialName("old_username")
        val oldUsername: String,
        @SerialName("new_username")
        val newUsername: String
    ) : TdChatEventAction()

    /**
     * The chat photo was changed
     *
     * @property oldPhoto Previous chat photo value
     * @property newPhoto New chat photo value
     */
    @Serializable
    @SerialName("chatEventPhotoChanged")
    data class ChatEventPhotoChanged(
        @SerialName("old_photo")
        val oldPhoto: TdPhoto?,
        @SerialName("new_photo")
        val newPhoto: TdPhoto?
    ) : TdChatEventAction()

    /**
     * The can_invite_users permission of a supergroup chat was toggled
     *
     * @property canInviteUsers New value of can_invite_users permission
     */
    @Serializable
    @SerialName("chatEventInvitesToggled")
    data class ChatEventInvitesToggled(
        @SerialName("can_invite_users")
        val canInviteUsers: Boolean
    ) : TdChatEventAction()

    /**
     * The linked chat of a supergroup was changed
     *
     * @property oldLinkedChatId Previous supergroup linked chat identifier
     * @property newLinkedChatId New supergroup linked chat identifier
     */
    @Serializable
    @SerialName("chatEventLinkedChatChanged")
    data class ChatEventLinkedChatChanged(
        @SerialName("old_linked_chat_id")
        val oldLinkedChatId: Long,
        @SerialName("new_linked_chat_id")
        val newLinkedChatId: Long
    ) : TdChatEventAction()

    /**
     * The slow_mode_delay setting of a supergroup was changed
     *
     * @property oldSlowModeDelay Previous value of slow_mode_delay
     * @property newSlowModeDelay New value of slow_mode_delay
     */
    @Serializable
    @SerialName("chatEventSlowModeDelayChanged")
    data class ChatEventSlowModeDelayChanged(
        @SerialName("old_slow_mode_delay")
        val oldSlowModeDelay: Int,
        @SerialName("new_slow_mode_delay")
        val newSlowModeDelay: Int
    ) : TdChatEventAction()

    /**
     * The sign_messages setting of a channel was toggled
     *
     * @property signMessages New value of sign_messages
     */
    @Serializable
    @SerialName("chatEventSignMessagesToggled")
    data class ChatEventSignMessagesToggled(
        @SerialName("sign_messages")
        val signMessages: Boolean
    ) : TdChatEventAction()

    /**
     * The supergroup sticker set was changed
     *
     * @property oldStickerSetId Previous identifier of the chat sticker set
     *                           0 if none
     * @property newStickerSetId New identifier of the chat sticker set
     *                           0 if none
     */
    @Serializable
    @SerialName("chatEventStickerSetChanged")
    data class ChatEventStickerSetChanged(
        @SerialName("old_sticker_set_id")
        val oldStickerSetId: Long,
        @SerialName("new_sticker_set_id")
        val newStickerSetId: Long
    ) : TdChatEventAction()

    /**
     * The supergroup location was changed
     *
     * @property oldLocation Previous location
     * @property newLocation New location
     */
    @Serializable
    @SerialName("chatEventLocationChanged")
    data class ChatEventLocationChanged(
        @SerialName("old_location")
        val oldLocation: TdChatLocation?,
        @SerialName("new_location")
        val newLocation: TdChatLocation?
    ) : TdChatEventAction()

    /**
     * The is_all_history_available setting of a supergroup was toggled
     *
     * @property isAllHistoryAvailable New value of is_all_history_available
     */
    @Serializable
    @SerialName("chatEventIsAllHistoryAvailableToggled")
    data class ChatEventIsAllHistoryAvailableToggled(
        @SerialName("is_all_history_available")
        val isAllHistoryAvailable: Boolean
    ) : TdChatEventAction()
}

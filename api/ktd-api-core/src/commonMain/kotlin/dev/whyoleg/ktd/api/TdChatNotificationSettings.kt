package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about notification settings for a chat
 *
 * @property useDefaultMuteFor If true, mute_for is ignored and the value for the relevant type of chat is used instead
 * @property muteFor Time left before notifications will be unmuted, in seconds
 * @property useDefaultSound If true, sound is ignored and the value for the relevant type of chat is used instead
 * @property sound The name of an audio file to be used for notification sounds
 *                 Only applies to iOS applications
 * @property useDefaultShowPreview If true, show_preview is ignored and the value for the relevant type of chat is used instead
 * @property showPreview True, if message content should be displayed in notifications
 * @property useDefaultDisablePinnedMessageNotifications If true, disable_pinned_message_notifications is ignored and the value for the relevant type of chat is used instead
 * @property disablePinnedMessageNotifications If true, notifications for incoming pinned messages will be created as for an ordinary unread message
 * @property useDefaultDisableMentionNotifications If true, disable_mention_notifications is ignored and the value for the relevant type of chat is used instead
 * @property disableMentionNotifications If true, notifications for messages with mentions will be created as for an ordinary unread message
 */
@Serializable
@SerialName("chatNotificationSettings")
data class TdChatNotificationSettings(
    @SerialName("use_default_mute_for")
    val useDefaultMuteFor: Boolean,
    @SerialName("mute_for")
    val muteFor: Int,
    @SerialName("use_default_sound")
    val useDefaultSound: Boolean,
    @SerialName("sound")
    val sound: String,
    @SerialName("use_default_show_preview")
    val useDefaultShowPreview: Boolean,
    @SerialName("show_preview")
    val showPreview: Boolean,
    @SerialName("use_default_disable_pinned_message_notifications")
    val useDefaultDisablePinnedMessageNotifications: Boolean,
    @SerialName("disable_pinned_message_notifications")
    val disablePinnedMessageNotifications: Boolean,
    @SerialName("use_default_disable_mention_notifications")
    val useDefaultDisableMentionNotifications: Boolean,
    @SerialName("disable_mention_notifications")
    val disableMentionNotifications: Boolean
) : TdObject

package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about notification settings for several chats
 *
 * @property muteFor Time left before notifications will be unmuted, in seconds
 * @property sound The name of an audio file to be used for notification sounds
 *                 Only applies to iOS applications
 * @property showPreview True, if message content should be displayed in notifications
 * @property disablePinnedMessageNotifications True, if notifications for incoming pinned messages will be created as for an ordinary unread message
 * @property disableMentionNotifications True, if notifications for messages with mentions will be created as for an ordinary unread message
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("scopeNotificationSettings")
data class TdScopeNotificationSettings(
    @SerialName("mute_for")
    val muteFor: Int,
    @SerialName("sound")
    val sound: String,
    @SerialName("show_preview")
    val showPreview: Boolean,
    @SerialName("disable_pinned_message_notifications")
    val disablePinnedMessageNotifications: Boolean,
    @SerialName("disable_mention_notifications")
    val disableMentionNotifications: Boolean,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse

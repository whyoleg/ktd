package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * A list of active notifications in a notification group has changed
 *
 * @property notificationGroupId Unique notification group identifier
 * @property type New type of the notification group
 * @property chatId Identifier of a chat to which all notifications in the group belong
 * @property notificationSettingsChatId Chat identifier, which notification settings must be applied to the added notifications
 * @property isSilent True, if the notifications should be shown without sound
 * @property totalCount Total number of unread notifications in the group, can be bigger than number of active notifications
 * @property addedNotifications List of added group notifications, sorted by notification ID
 * @property removedNotificationIds Identifiers of removed group notifications, sorted by notification ID
 */
@Serializable
@SerialName("updateNotificationGroup")
data class TdUpdateNotificationGroup(
    @SerialName("notification_group_id")
    val notificationGroupId: Int,
    @SerialName("type")
    val type: TdNotificationGroupType,
    @SerialName("chat_id")
    val chatId: Long,
    @SerialName("notification_settings_chat_id")
    val notificationSettingsChatId: Long,
    @SerialName("is_silent")
    val isSilent: Boolean,
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("added_notifications")
    val addedNotifications: List<TdNotification>,
    @SerialName("removed_notification_ids")
    val removedNotificationIds: IntArray
) : TdUpdate

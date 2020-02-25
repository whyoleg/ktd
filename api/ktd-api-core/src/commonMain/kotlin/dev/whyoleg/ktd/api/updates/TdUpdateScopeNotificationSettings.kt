package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * Notification settings for some type of chats were updated
 *
 * @property scope Types of chats for which notification settings were updated
 * @property notificationSettings The new notification settings
 */
@Serializable
@SerialName("updateScopeNotificationSettings")
data class TdUpdateScopeNotificationSettings(
    @SerialName("scope")
    val scope: TdNotificationSettingsScope,
    @SerialName("notification_settings")
    val notificationSettings: TdScopeNotificationSettings
) : TdUpdate

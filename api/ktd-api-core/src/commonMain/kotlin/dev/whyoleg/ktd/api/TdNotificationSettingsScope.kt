package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the types of chats to which notification settings are applied
 */
@Serializable
sealed class TdNotificationSettingsScope : TdObject {
    /**
     * Notification settings applied to all private and secret chats when the corresponding chat setting has a default value
     */
    @Serializable
    @SerialName("notificationSettingsScopePrivateChats")
    object PrivateChats : TdNotificationSettingsScope()

    /**
     * Notification settings applied to all basic groups and supergroups when the corresponding chat setting has a default value
     */
    @Serializable
    @SerialName("notificationSettingsScopeGroupChats")
    object GroupChats : TdNotificationSettingsScope()

    /**
     * Notification settings applied to all channels when the corresponding chat setting has a default value
     */
    @Serializable
    @SerialName("notificationSettingsScopeChannelChats")
    object ChannelChats : TdNotificationSettingsScope()
}

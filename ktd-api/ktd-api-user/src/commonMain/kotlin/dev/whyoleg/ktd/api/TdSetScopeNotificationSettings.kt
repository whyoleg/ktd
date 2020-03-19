package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes notification settings for chats of a given type
 *
 * @property scope Types of chats for which to change the notification settings
 * @property notificationSettings The new notification settings for the given scope
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setScopeNotificationSettings")
data class TdSetScopeNotificationSettings(
    @SerialName("scope")
    val scope: TdNotificationSettingsScope? = null,
    @SerialName("notification_settings")
    val notificationSettings: TdScopeNotificationSettings? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetScopeNotificationSettings {
        return copy(extra = extra.copy(id = id))
    }
}

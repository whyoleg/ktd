package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the notification settings for chats of a given type
 *
 * @property scope Types of chats for which to return the notification settings information
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getScopeNotificationSettings")
data class TdGetScopeNotificationSettings(
    @SerialName("scope")
    val scope: TdNotificationSettingsScope? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdScopeNotificationSettings> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetScopeNotificationSettings {
        return copy(extra = extra.copy(id = id))
    }
}

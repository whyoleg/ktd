package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Resets all notification settings to their default values
 * By default, all chats are unmuted, the sound is set to "default" and message previews are shown
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("resetAllNotificationSettings")
data class TdResetAllNotificationSettings(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdResetAllNotificationSettings {
        return copy(extra = extra.copy(id = id))
    }
}

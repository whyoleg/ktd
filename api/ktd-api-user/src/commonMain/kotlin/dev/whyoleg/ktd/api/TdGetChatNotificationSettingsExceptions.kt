package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns list of chats with non-default notification settings
 *
 * @property scope If specified, only chats from the specified scope will be returned
 * @property compareSound If true, also chats with non-default sound will be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getChatNotificationSettingsExceptions")
data class TdGetChatNotificationSettingsExceptions(
    @SerialName("scope")
    val scope: TdNotificationSettingsScope? = null,
    @SerialName("compare_sound")
    val compareSound: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChats> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetChatNotificationSettingsExceptions {
        return copy(extra = extra.copy(id = id))
    }
}

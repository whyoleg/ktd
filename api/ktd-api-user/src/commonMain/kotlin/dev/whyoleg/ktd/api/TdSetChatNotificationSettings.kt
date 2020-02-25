package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the notification settings of a chat
 * Notification settings of a chat with the current user (Saved Messages) can't be changed
 *
 * @property chatId Chat identifier
 * @property notificationSettings New notification settings for the chat
 *                                If the chat is muted for more than 1 week, it is considered to be muted forever
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setChatNotificationSettings")
data class TdSetChatNotificationSettings(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("notification_settings")
    val notificationSettings: TdChatNotificationSettings? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetChatNotificationSettings {
        return copy(extra = extra.copy(id = id))
    }
}

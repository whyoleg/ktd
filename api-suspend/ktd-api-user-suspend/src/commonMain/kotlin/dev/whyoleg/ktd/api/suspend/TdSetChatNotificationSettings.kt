package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the notification settings of a chat
 * Notification settings of a chat with the current user (Saved Messages) can't be changed
 *
 * @property chatId Chat identifier
 * @property notificationSettings New notification settings for the chat
 *                                If the chat is muted for more than 1 week, it is considered to be muted forever
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setChatNotificationSettings(
    chatId: Long = 0L,
    notificationSettings: TdChatNotificationSettings? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetChatNotificationSettings(chatId, notificationSettings, extra))

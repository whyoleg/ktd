package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the value of the default disable_notification parameter, used when a message is sent to a chat
 *
 * @property chatId Chat identifier
 * @property defaultDisableNotification New value of default_disable_notification
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.toggleChatDefaultDisableNotification(
    chatId: Long = 0L,
    defaultDisableNotification: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdToggleChatDefaultDisableNotification(chatId, defaultDisableNotification, extra))

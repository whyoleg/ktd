package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends a notification about user activity in a chat
 *
 * @property chatId Chat identifier
 * @property action The action description
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendChatAction(
    chatId: Long = 0L,
    action: TdChatAction? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSendChatAction(chatId, action, extra))

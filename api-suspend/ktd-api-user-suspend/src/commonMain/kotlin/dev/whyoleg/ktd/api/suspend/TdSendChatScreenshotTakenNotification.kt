package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends a notification about a screenshot taken in a chat
 * Supported only in private and secret chats
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendChatScreenshotTakenNotification(chatId: Long = 0L, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdSendChatScreenshotTakenNotification(chatId, extra))

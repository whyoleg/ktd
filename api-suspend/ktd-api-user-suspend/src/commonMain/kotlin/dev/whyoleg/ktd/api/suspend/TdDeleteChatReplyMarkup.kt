package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Deletes the default reply markup from a chat
 * Must be called after a one-time keyboard or a ForceReply reply markup has been used
 * UpdateChatReplyMarkup will be sent if the reply markup will be changed
 *
 * @property chatId Chat identifier
 * @property messageId The message identifier of the used keyboard
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.deleteChatReplyMarkup(
    chatId: Long = 0L,
    messageId: Long = 0L,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdDeleteChatReplyMarkup(chatId, messageId, extra))

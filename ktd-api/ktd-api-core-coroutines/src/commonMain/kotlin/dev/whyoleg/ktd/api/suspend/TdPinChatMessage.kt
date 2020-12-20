package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Pins a message in a chat
 * Requires can_pin_messages rights
 *
 * @property chatId Identifier of the chat
 * @property messageId Identifier of the new pinned message
 * @property disableNotification True, if there should be no notification about the pinned message
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.pinChatMessage(
    chatId: Long = 0L,
    messageId: Long = 0L,
    disableNotification: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdPinChatMessage(chatId, messageId, disableNotification, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes the pinned message from a chat
 * Requires can_pin_messages rights in the group or channel
 *
 * @property chatId Identifier of the chat
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.unpinChatMessage(chatId: Long = 0L, extra: TdExtra = TdExtra.EMPTY):
        TdOk = exec(TdUnpinChatMessage(chatId, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes current user from chat members
 * Private and secret chats can't be left using this method
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.leaveChat(chatId: Long = 0L, extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdLeaveChat(chatId, extra))

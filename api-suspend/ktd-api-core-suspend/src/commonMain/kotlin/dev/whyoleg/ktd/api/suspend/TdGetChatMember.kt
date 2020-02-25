package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a single member of a chat
 *
 * @property chatId Chat identifier
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getChatMember(
    chatId: Long = 0L,
    userId: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdChatMember = exec(TdGetChatMember(chatId, userId, extra))

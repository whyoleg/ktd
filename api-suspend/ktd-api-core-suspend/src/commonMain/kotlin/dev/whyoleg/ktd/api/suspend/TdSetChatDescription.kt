package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes information about a chat
 * Available for basic groups, supergroups, and channels
 * Requires can_change_info rights
 *
 * @property chatId Identifier of the chat
 * @property description New chat description
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setChatDescription(
    chatId: Long = 0L,
    description: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetChatDescription(chatId, description, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the chat members permissions
 * Supported only for basic groups and supergroups
 * Requires can_restrict_members administrator right
 *
 * @property chatId Chat identifier
 * @property permissions New non-administrator members permissions in the chat
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setChatPermissions(
    chatId: Long = 0L,
    permissions: TdChatPermissions? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetChatPermissions(chatId, permissions, extra))

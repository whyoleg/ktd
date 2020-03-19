package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the slow mode delay of a chat
 * Available only for supergroups
 * Requires can_restrict_members rights
 *
 * @property chatId Chat identifier
 * @property slowModeDelay New slow mode delay for the chat
 *                         Must be one of 0, 10, 30, 60, 300, 900, 3600
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setChatSlowModeDelay(
    chatId: Long = 0L,
    slowModeDelay: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetChatSlowModeDelay(chatId, slowModeDelay, extra))

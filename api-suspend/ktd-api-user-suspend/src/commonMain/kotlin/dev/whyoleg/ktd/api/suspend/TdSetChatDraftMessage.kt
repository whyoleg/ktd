package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the draft message in a chat
 *
 * @property chatId Chat identifier
 * @property draftMessage New draft message
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setChatDraftMessage(
    chatId: Long = 0L,
    draftMessage: TdDraftMessage? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetChatDraftMessage(chatId, draftMessage, extra))

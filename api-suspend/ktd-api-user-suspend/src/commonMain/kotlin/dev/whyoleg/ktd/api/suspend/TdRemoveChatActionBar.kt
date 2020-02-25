package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes a chat action bar without any other action
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.removeChatActionBar(chatId: Long = 0L, extra: TdExtra = TdExtra.EMPTY):
        TdOk = exec(TdRemoveChatActionBar(chatId, extra))

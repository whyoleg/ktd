package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns an existing chat corresponding to a known secret chat
 *
 * @property secretChatId Secret chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.createSecretChat(secretChatId: Int = 0, extra: TdExtra = TdExtra.EMPTY):
        TdChat = exec(TdCreateSecretChat(secretChatId, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a secret chat by its identifier
 * This is an offline request
 *
 * @property secretChatId Secret chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getSecretChat(secretChatId: Int = 0, extra: TdExtra = TdExtra.EMPTY):
        TdSecretChat = exec(TdGetSecretChat(secretChatId, extra))

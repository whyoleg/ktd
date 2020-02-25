package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Closes a secret chat, effectively transferring its state to secretChatStateClosed
 *
 * @property secretChatId Secret chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.closeSecretChat(secretChatId: Int = 0, extra: TdExtra = TdExtra.EMPTY):
        TdOk = exec(TdCloseSecretChat(secretChatId, extra))

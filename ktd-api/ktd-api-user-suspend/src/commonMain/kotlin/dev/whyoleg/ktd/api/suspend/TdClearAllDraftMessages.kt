package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Clears draft messages in all chats
 *
 * @property excludeSecretChats If true, local draft messages in secret chats will not be cleared
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.clearAllDraftMessages(excludeSecretChats: Boolean = false,
        extra: TdExtra = TdExtra.EMPTY): TdOk = exec(TdClearAllDraftMessages(excludeSecretChats,
        extra))

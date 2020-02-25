package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Creates a new secret chat
 * Returns the newly created chat
 *
 * @property userId Identifier of the target user
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.createNewSecretChat(userId: Int = 0, extra: TdExtra = TdExtra.EMPTY):
        TdChat = exec(TdCreateNewSecretChat(userId, extra))

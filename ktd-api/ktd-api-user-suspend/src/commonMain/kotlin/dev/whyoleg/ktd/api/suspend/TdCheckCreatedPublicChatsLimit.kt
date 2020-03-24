package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Checks whether the maximum number of owned public chats has been reached
 * Returns corresponding error if the limit was reached
 *
 * @property type Type of the public chats, for which to check the limit
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.checkCreatedPublicChatsLimit(type: TdPublicChatType? = null,
        extra: TdExtra = TdExtra.EMPTY): TdOk = exec(TdCheckCreatedPublicChatsLimit(type, extra))

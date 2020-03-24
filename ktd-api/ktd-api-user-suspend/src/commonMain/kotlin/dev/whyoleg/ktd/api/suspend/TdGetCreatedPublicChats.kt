package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a list of public chats of the specified type, owned by the user
 *
 * @property type Type of the public chats to return
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getCreatedPublicChats(type: TdPublicChatType? = null, extra: TdExtra =
        TdExtra.EMPTY): TdChats = exec(TdGetCreatedPublicChats(type, extra))

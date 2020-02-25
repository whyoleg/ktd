package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes client data associated with a chat
 *
 * @property chatId Chat identifier
 * @property clientData New value of client_data
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setChatClientData(
    chatId: Long = 0L,
    clientData: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetChatClientData(chatId, clientData, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a message, if it is available locally without sending network request
 * This is an offline request
 *
 * @property chatId Identifier of the chat the message belongs to
 * @property messageId Identifier of the message to get
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getMessageLocally(
    chatId: Long = 0L,
    messageId: Long = 0L,
    extra: TdExtra = TdExtra.EMPTY
): TdMessage = exec(TdGetMessageLocally(chatId, messageId, extra))

package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about messages
 * If a message is not found, returns null on the corresponding position of the result
 *
 * @property chatId Identifier of the chat the messages belong to
 * @property messageIds Identifiers of the messages to get
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getMessages(
    chatId: Long = 0L,
    messageIds: LongArray = longArrayOf(),
    extra: TdExtra = TdExtra.EMPTY
): TdMessages = exec(TdGetMessages(chatId, messageIds, extra))

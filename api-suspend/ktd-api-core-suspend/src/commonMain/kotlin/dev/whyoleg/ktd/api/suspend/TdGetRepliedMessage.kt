package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a message that is replied by given message
 *
 * @property chatId Identifier of the chat the message belongs to
 * @property messageId Identifier of the message reply to which get
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getRepliedMessage(
    chatId: Long = 0L,
    messageId: Long = 0L,
    extra: TdExtra = TdExtra.EMPTY
): TdMessage = exec(TdGetRepliedMessage(chatId, messageId, extra))

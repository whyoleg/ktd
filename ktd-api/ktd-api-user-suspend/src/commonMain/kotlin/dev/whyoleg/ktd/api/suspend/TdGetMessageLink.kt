package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a private HTTPS link to a message in a chat
 * Available only for already sent messages in supergroups and channels
 * The link will work only for members of the chat
 *
 * @property chatId Identifier of the chat to which the message belongs
 * @property messageId Identifier of the message
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getMessageLink(
    chatId: Long = 0L,
    messageId: Long = 0L,
    extra: TdExtra = TdExtra.EMPTY
): TdHttpUrl = exec(TdGetMessageLink(chatId, messageId, extra))

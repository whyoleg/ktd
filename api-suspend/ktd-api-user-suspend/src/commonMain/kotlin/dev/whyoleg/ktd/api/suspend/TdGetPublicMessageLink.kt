package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a public HTTPS link to a message
 * Available only for messages in supergroups and channels with a username
 *
 * @property chatId Identifier of the chat to which the message belongs
 * @property messageId Identifier of the message
 * @property forAlbum Pass true if a link for a whole media album should be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getPublicMessageLink(
    chatId: Long = 0L,
    messageId: Long = 0L,
    forAlbum: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdPublicMessageLink = exec(TdGetPublicMessageLink(chatId, messageId, forAlbum, extra))

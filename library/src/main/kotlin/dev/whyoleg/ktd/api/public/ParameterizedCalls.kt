@file:Suppress("unused")

package dev.whyoleg.ktd.api.public

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a public HTTPS link to a message. Available only for messages in supergroups and channels with username
 *
 * @chatId - Identifier of the chat to which the message belongs
 * @messageId - Identifier of the message
 * @forAlbum - Pass true if a link for a whole media album should be returned
 */
suspend fun TelegramClient.getPublicMessageLink(
    chatId: Long,
    messageId: Long,
    forAlbum: Boolean
): PublicMessageLink = public(
    GetPublicMessageLink(
        chatId,
        messageId,
        forAlbum
    )
)

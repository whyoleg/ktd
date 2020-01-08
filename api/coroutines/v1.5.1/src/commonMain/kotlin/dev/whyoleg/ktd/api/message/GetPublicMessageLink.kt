@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a public HTTPS link to a message
 * Available only for messages in supergroups and channels with username
 *
 * @chatId - Identifier of the chat to which the message belongs
 * @messageId - Identifier of the message
 * @forAlbum - Pass true if a link for a whole media album should be returned
 */
suspend fun TelegramClient.getPublicMessageLink(
    chatId: Long = 0L,
    messageId: Long = 0L,
    forAlbum: Boolean = false
): PublicMessageLink = message(
    GetPublicMessageLink(
        chatId,
        messageId,
        forAlbum
    )
)

/**
 * Returns a public HTTPS link to a message
 * Available only for messages in supergroups and channels with username
 */
suspend fun TelegramClient.message(
    f: GetPublicMessageLink
): PublicMessageLink = exec(f) as PublicMessageLink
